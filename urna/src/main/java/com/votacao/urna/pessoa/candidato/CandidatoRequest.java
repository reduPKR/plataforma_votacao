package com.votacao.urna.pessoa.candidato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CandidatoRequest {
    @NotNull
    private String codigoCandidato;
    @NotNull
    private String nome;
    @CPF
    private String cpf;
}
