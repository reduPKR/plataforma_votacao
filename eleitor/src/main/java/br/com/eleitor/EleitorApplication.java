package br.com.eleitor;

import br.com.eleitor.eleitor.EleitorService;
import br.com.eleitor.voto.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EleitorApplication {
	@Autowired
	private EleitorService eleitorService;
	@Autowired
	private VotoService votoService;

	public static void main(String[] args) {
		SpringApplication.run(EleitorApplication.class, args);
	}


}
