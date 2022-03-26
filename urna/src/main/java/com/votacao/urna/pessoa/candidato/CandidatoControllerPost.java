package com.votacao.urna.pessoa.candidato;

import com.votacao.urna.pessoa.PessoaEntity;
import com.votacao.urna.pessoa.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("candidato")
public class CandidatoControllerPost {
    private CandidatoRepository repository;
    private PessoaRepository pessoaRepository;

    public CandidatoControllerPost(CandidatoRepository repository, PessoaRepository pessoaRepository) {
        this.repository = repository;
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    public ResponseEntity<CandidatoResponse> post(@Validated @RequestBody CandidatoRequest request){
        Optional<PessoaEntity> optional = pessoaRepository.findByCpf(request.getCpf());

        CandidatoMapper candidatoMapper = new CandidatoMapper();
        CandidatoEntity candidatoEntity = candidatoMapper.requestToEntity(request);
        if(optional.isPresent()){
            PessoaEntity pessoaEntity = optional.get();

            candidatoEntity.setPessoa(pessoaEntity);
            repository.save(candidatoEntity);

            if(candidatoEntity.getId() != 0)
                return ResponseEntity.ok(candidatoMapper.entityToResponse(candidatoEntity, HttpStatus.OK));
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(candidatoMapper.entityToResponse(HttpStatus.FORBIDDEN));
    }
}
