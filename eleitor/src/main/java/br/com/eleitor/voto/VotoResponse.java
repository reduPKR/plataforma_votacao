package br.com.eleitor.voto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class VotoResponse {
    private  boolean eleitor;
    private boolean candidato;
    private LocalDate data;
}
