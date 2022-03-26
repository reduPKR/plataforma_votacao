package com.votacao.urna.pessoa.eleitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EleitorResponse {
    private String nome;
    private String cpf;
    private long codigoValidacao;

}
