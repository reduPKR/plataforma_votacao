package com.votacao.urna.pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Boolean canditado;

    public String getDataNascimentoString() {
        return dataNascimento.toString();
    }
}
