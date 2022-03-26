package br.com.candidato.voto;

import java.util.List;
import java.util.stream.Collectors;

public class VotoMapper {
    public List<VotoResponse> toResponse(List<VotoEntity> list) {
        return list.stream()
                .map(item -> new VotoResponse(item.isEleitor(), item.isCandidato(),item.getData()))
                .collect(Collectors.toList());
    }
}
