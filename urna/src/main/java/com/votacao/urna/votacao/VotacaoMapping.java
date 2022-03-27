package com.votacao.urna.votacao;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<VotoResponse> analise(List<VotoEntity> lista) {
        ArrayList<VotoResponse> response = new ArrayList<VotoResponse>();

        int pos = -1;
        for(VotoEntity item : lista){
            pos = existe(response, item.getCodigoCandidato());

            if(pos == -1){
                response.add(new VotoResponse(item.getCodigoCandidato(), lista.size()));
                pos = response.size()-1;
            }

            if(item.isCandidato() && item.isEleitor())
                response.get(pos).incTotalVotosValidos();
            else
                response.get(pos).incTotalVotosInvalidos();
        }

        return response;
    }

    private int existe(ArrayList<VotoResponse> response, String codigoCandidato) {
        int pos = -1;
        int aux = 0;
        for (VotoResponse item: response) {
            if (item.getCodigoCandidato().equals(codigoCandidato)){
                pos = aux;
                break;
            }
             aux++;
        }
        return pos;
    }
}
