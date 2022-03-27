package com.votacao.urna.votacao;

import ch.qos.logback.core.util.FixedDelay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("votos")
public class VotoControllerGet {
    @Autowired
    private VotoRepository votoRepository;

    @GetMapping
    @Scheduled(fixedDelay  = 60000)
    public List<VotoResponse> get(){
        Optional<List> optional = votoRepository.findByDataOrderByCodigoCandidato(LocalDate.now());

        if(optional.isPresent()){
            List lista = optional.get();
            VotacaoMapping mapping = new VotacaoMapping();
            return mapping.Analise(lista);
        }
        return null;
    }
}
