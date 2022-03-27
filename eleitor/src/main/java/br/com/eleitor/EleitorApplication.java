package br.com.eleitor;

import br.com.eleitor.eleitor.EleitorService;
import br.com.eleitor.kafka.KafkaConsumer;
import br.com.eleitor.voto.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EleitorApplication implements CommandLineRunner {
	@Autowired
	private EleitorService eleitorService;
	@Autowired
	private VotoService votoService;

	public static void main(String[] args) {
		SpringApplication.run(EleitorApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		KafkaConsumer kafkaConsumer = new KafkaConsumer(eleitorService, votoService);
		kafkaConsumer.escutar();
	}
}
