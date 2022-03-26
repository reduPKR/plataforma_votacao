package com.votacao.urna.votacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VotacaoRequest {
    @NotNull
    @CPF
    private String cpfEleitor;
    @NotNull
    private  String codigoEleitor;
    @NotNull
    private String codidoCanditado;
}
