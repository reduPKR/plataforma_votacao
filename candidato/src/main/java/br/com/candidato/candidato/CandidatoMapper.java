package br.com.candidato.candidato;

import br.com.candidato.voto.VotoResponse;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

public class CandidatoMapper {
    public List toResponse(List<CandidatoEntity> list) {
        return list
                .stream()
                .map(item -> new CandidatoResponse(
                        item.getCodigoCandidato(),
                        item.getPessoaNome(),
                        item.getPessoaCpf()))
                .collect(Collectors.toList());
    }
}
