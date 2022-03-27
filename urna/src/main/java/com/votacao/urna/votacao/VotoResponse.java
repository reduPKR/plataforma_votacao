package com.votacao.urna.votacao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VotoResponse {
    private String codigoCandidato;
    private  boolean eleitor;
    private boolean candidato;
}
