package com.votacao.urna.pessoa.candidato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class CandidatoResponse {
    private String codigoCandidato;
    private String nome;
    private String cpf;
    private HttpStatus status;

    public CandidatoResponse(HttpStatus status) {
        this.status = status;
    }
}
