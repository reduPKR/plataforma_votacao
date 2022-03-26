package br.com.candidato;

import br.com.candidato.candidato.CandidatoService;
import br.com.candidato.kafka.KafkaConsumer;
import br.com.candidato.voto.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class CandidatoApplication implements CommandLineRunner {
	@Autowired
	private CandidatoService candidatoService;
	@Autowired
	private VotoService votoService;

	public static void main(String[] args) {
		SpringApplication.run(CandidatoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		KafkaConsumer kafkaConsumer = new KafkaConsumer(candidatoService, votoService);
		kafkaConsumer.escutar();
	}
}
