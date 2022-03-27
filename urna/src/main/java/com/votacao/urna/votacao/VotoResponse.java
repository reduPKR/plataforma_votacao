package com.votacao.urna.votacao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class VotoResponse {
    private String codigoCandidato;
    private int totalVotos;
    private int totalVotosValidos;
    private int totalVotosInvalidos;

    public VotoResponse(String codigoCandidato, int totalVotos) {
        this.codigoCandidato = codigoCandidato;
        this.totalVotos = totalVotos;
        this.totalVotosValidos = 0;
        this.totalVotosInvalidos = 0;
    }

    public float getPercentValido(){
        return (float)(totalVotosValidos*100)/totalVotos;
    }

    public float getPercentInvalido(){
        return (float) (totalVotosInvalidos*100)/totalVotos;
    }


    public void incTotalVotosValidos() {
        this.totalVotosValidos++;
    }

    public void incTotalVotosInvalidos() {
        this.totalVotosInvalidos++;
    }
}
