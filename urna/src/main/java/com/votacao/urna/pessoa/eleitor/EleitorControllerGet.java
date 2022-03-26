package com.votacao.urna.pessoa.eleitor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eleitor")
public class EleitorControllerGet {
    private EleitorRepository repository;
    public EleitorControllerGet(EleitorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EleitorResponse> get(){
        List lista = repository.findAll();
        EleitorValidar validar = new EleitorValidar();
        return validar.entityToResponse(lista);
    }
}
