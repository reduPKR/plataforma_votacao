package br.com.candidato.candidato;

import br.com.candidato.voto.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    public List listaCandidato() {
        List list = candidatoRepository.findAll(Sort.by(Sort.Direction.ASC, "codigoCandidato"));
        CandidatoMapper candidatoMapper = new CandidatoMapper();
        return candidatoMapper.toResponse(list);
    }

    public boolean validar(Voto voto){
        Optional<CandidatoEntity> optional = candidatoRepository.findByCodigoCandidato(voto.getCodidoCanditado());

        if(optional.isPresent()){
            CandidatoEntity entity = optional.get();
            String cpf = entity.getPessoaCpf();
            long cpfinteiro = Long.parseLong(cpf);

            return cpfinteiro % 2 == 0;
        }

        return false;
    }
}
