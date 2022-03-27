package com.votacao.urna.votacao;

import com.votacao.urna.kafka.KafkaDispatcher;
import com.votacao.urna.kafka.Topicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/votar")
public class VotoControllerPost {
    @Autowired
    private VotoRepository votoRepository;

    @PostMapping
    public String post(@Validated @RequestBody VotacaoRequest votacaoRequest){
        try {
            VotacaoMapping votacaoMapping = new VotacaoMapping();
            VotoEntity votoEntity = VotacaoMapping.toEntity(votacaoRequest.getCodidoCanditado());

            votoRepository.save(votoEntity);

            if(votoEntity.getId() != 0){
                Voto voto = votacaoMapping.toObject(votoEntity.getId(), votacaoRequest);
                String chave = votacaoMapping.chave();
                validar(voto, chave);
                return "voto enviado para validação";
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Ocorreu um erro";
    }

    private void validar(Voto voto, String chave) throws ExecutionException, InterruptedException{
        KafkaDispatcher dispatcher = new KafkaDispatcher<Voto>();
        dispatcher.send(Topicos.VALIDAR_VOTO_ELEITOR.name(), chave, voto);
        dispatcher.send(Topicos.VALIDAR_VOTO_CANDIDATO.name(), chave, voto);
    }
}
