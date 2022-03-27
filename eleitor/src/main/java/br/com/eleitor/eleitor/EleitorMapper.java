package br.com.eleitor.eleitor;

import java.util.List;
import java.util.stream.Collectors;

public class EleitorMapper {
    public List toResponse(List<EleitorEntity> list) {
        return list
                .stream()
                .map(item -> new EleitorResponse(
                        item.getPessoaNome(),
                        item.getPessoaCpf(),
                        item.getCodigoValidacao()
                        )
                ).collect(Collectors.toList());
    }
}
