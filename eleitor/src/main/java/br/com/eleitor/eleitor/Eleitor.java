package br.com.eleitor.eleitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Eleitor {
    private Long id;
    private String nome;
    private String cpf;
    private long codigoValidacao;
    private LocalDate dataNascimento;
}
