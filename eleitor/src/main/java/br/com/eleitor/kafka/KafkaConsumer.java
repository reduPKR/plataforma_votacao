package br.com.eleitor.kafka;

import br.com.eleitor.eleitor.EleitorService;
import br.com.eleitor.voto.Voto;
import br.com.eleitor.voto.VotoService;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaConsumer {
    private final EleitorService eleitorService;
    private final VotoService votoService;

    public KafkaConsumer(EleitorService eleitorService, VotoService votoService) {
        this.eleitorService = eleitorService;
        this.votoService = votoService;
    }

    public void escutar() {
        var validarCanditado = new KafkaConsumer(eleitorService, votoService);
        System.out.println("validar eleitor <--------------------------");
        var service = new KafkaService<Voto>(
                KafkaConsumer.class.getSimpleName(),
                "VALIDAR_VOTO_ELEITOR",
                eleitorService,
                votoService,
                validarCanditado::parse,
                Voto.class);
        service.run();
    }

    private void parse(ConsumerRecord<String, Voto> record) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Processando se o eleitor é para um valido");
        System.out.println(record.key());
        System.out.println(record.value());

        try {
            Thread.sleep(100);
            Voto voto = record.value();

            if(eleitorService.validar(voto)){
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
