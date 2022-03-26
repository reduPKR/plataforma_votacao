package com.votacao.urna.votacao;

import java.time.LocalDate;

public class VotacaoMapping {
    private String chave;

    public static VotoEntity toEntity() {
        return new VotoEntity();
    }

    public Voto toObject(Long id, VotacaoRequest votacaoRequest) {
        gerarChave(votacaoRequest);
        return new Voto(id, votacaoRequest);
    }

    private void gerarChave(VotacaoRequest votacaoRequest) {
        chave = votacaoRequest.getCodigoEleitor()+"#"+
                votacaoRequest.getCodidoCanditado()+"#"+
                LocalDate.now().toString();
    }

    public String chave() {
        return chave;
    }
}
