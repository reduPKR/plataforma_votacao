package br.com.eleitor.eleitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EleitorResponse {
    private String nome;
    private String cpf;
    private long codigoValidacao;

}
