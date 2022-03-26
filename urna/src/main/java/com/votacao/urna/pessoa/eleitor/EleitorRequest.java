package com.votacao.urna.pessoa.eleitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EleitorRequest {
    @NotNull
    private String nome;
    @CPF
    private String cpf;
    @Past
    private LocalDate dataNascimento;

    public String getDataNascimentoString() {
        return dataNascimento.toString();
    }
}

