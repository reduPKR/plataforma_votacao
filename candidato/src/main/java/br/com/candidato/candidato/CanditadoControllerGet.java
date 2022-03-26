package br.com.candidato.candidato;

import br.com.candidato.voto.VotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CanditadoControllerGet {
    @Autowired
    private CandidatoService service;

    @GetMapping
    public List List(){
       return service.listaCandidato();
    }
}
