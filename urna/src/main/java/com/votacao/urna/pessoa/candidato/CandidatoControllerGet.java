package com.votacao.urna.pessoa.candidato;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("candidato")
public class CandidatoControllerGet {
    private CandidatoRepository repository;
    public CandidatoControllerGet(CandidatoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CandidatoResponse> get(){
        List lista = repository.findAll();
        CandidatoMapper candidatoMapper = new CandidatoMapper();
        return candidatoMapper.entityToResponse(lista);
    }
}
