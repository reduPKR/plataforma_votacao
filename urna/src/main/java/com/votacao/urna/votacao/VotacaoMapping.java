package com.votacao.urna.votacao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class VotacaoMapping {
    private String chave;

    public static VotoEntity toEntity(String candidato) {
        return new VotoEntity(candidato);
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

    public List<VotoResponse> Analise(List<VotoEntity> lista) {
        return lista
                .stream()
                .map(item -> new VotoResponse(
                        item.getCodigoCandidato(),
                        item.isEleitor(),
                        item.isCandidato()
                    )
                ).collect(Collectors.toList());
    }
}
