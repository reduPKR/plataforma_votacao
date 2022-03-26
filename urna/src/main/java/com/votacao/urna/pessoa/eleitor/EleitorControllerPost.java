package com.votacao.urna.pessoa.eleitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eleitor")
public class EleitorControllerPost {
    //@Autowired
    private EleitorRepository repository;
    public EleitorControllerPost(EleitorRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public ResponseEntity<EleitorResponse> post(@Validated @RequestBody EleitorRequest request){
        EleitorValidar eleitorValidar = new EleitorValidar();
        EleitorEntity eleitorEntity = eleitorValidar.requestToEntity(request);

        repository.save(eleitorEntity);

        if(eleitorEntity.getId() != 0)
            return ResponseEntity.ok(eleitorValidar.entityToResponse(eleitorEntity));
        return ResponseEntity.badRequest().build();
    }
}
