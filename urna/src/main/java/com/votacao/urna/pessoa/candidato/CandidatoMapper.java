package com.votacao.urna.pessoa.candidato;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

public class CandidatoMapper {
    public CandidatoEntity requestToEntity(CandidatoRequest request) {
        return new CandidatoEntity(request.getCodigoCandidato());
    }

    public CandidatoResponse entityToResponse(CandidatoEntity canditado, HttpStatus status) {
        return new CandidatoResponse(canditado.getCodigoCandidato(),
                canditado.getPessoaNome(),
                canditado.getPessoaCpf(),
                status
        );
    }

    public CandidatoResponse entityToResponse(HttpStatus status) {
        return new CandidatoResponse(status);
    }

    public List<CandidatoResponse> entityToResponse(List<CandidatoEntity> entity) {
        return entity
                .stream()
                .map(item -> new CandidatoResponse(
                        item.getCodigoCandidato(),
                        item.getPessoaNome(),
                        item.getPessoaCpf(),
                        HttpStatus.OK))
                .collect(Collectors.toList());
    }
}
