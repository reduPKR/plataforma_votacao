package br.com.candidato.kafka;

import br.com.candidato.candidato.CandidatoService;
import br.com.candidato.voto.Voto;
import br.com.candidato.voto.VotoService;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaConsumer {
    private final CandidatoService candidatoService;
    private final VotoService votoService;

    public KafkaConsumer(CandidatoService candidatoService, VotoService votoService) {
        this.candidatoService = candidatoService;
        this.votoService = votoService;
    }

    public void escutar() {
        var validarCanditado = new KafkaConsumer(candidatoService, votoService);
        System.out.println("validar candidato <--------------------------");
        var service = new KafkaService<Voto>(
                KafkaConsumer.class.getSimpleName(),
                "VALIDAR_VOTO_CANDIDATO",
                candidatoService,
                votoService,
                validarCanditado::parse,
                Voto.class);
        service.run();
    }

    private void parse(ConsumerRecord<String, Voto> record) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Processando se o candidato é para um valido");
        System.out.println(record.key());
        System.out.println(record.value());

        try {
            Thread.sleep(100);
            Voto voto = record.value();

            if(candidatoService.validar(voto)){
                System.out.println("--------------------------> Aprovando");
                votoService.aprovar(voto);
            }else
                System.out.println("--------------------------> Reprovando");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order processed");
    }
}
