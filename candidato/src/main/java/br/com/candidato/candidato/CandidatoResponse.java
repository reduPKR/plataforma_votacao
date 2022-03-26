package br.com.candidato.candidato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class CandidatoResponse {
    private String codigoCandidato;
    private String nome;
    private String cpf;
}

