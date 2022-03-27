package com.votacao.urna.votacao;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Voto {
    private Long id;
    private String cpfEleitor;
    private  long codigoEleitor;
    private String codidoCanditado;

    public Voto(Long id, VotacaoRequest votacaoRequest) {
        this.id = id;
        this.codidoCanditado = votacaoRequest.getCodidoCanditado();
        this.codigoEleitor = votacaoRequest.getCodigoEleitor();
        this.cpfEleitor = votacaoRequest.getCpfEleitor();
    }
}
