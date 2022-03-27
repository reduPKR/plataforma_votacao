package br.com.eleitor.eleitor;

import br.com.eleitor.voto.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleitorService {
    @Autowired
    private EleitorRepository eleitorRepository;

    public List lista() {
        List list = eleitorRepository.findAll(Sort.by(Sort.Direction.ASC, "codigoValidacao"));
        EleitorMapper eleitorMapper = new EleitorMapper();
        return eleitorMapper.toResponse(list);
    }

    public boolean validar(Voto voto){
        Optional<EleitorEntity> optional = eleitorRepository.findByCodigoValidacao(voto.getCodigoEleitor());

        if(optional.isPresent()){
            EleitorEntity entity = optional.get();

            if(entity.getCodigoValidacao() == gerarCodigo(entity))
                return true;
        }
        return false;
    }

    private int gerarCodigo(EleitorEntity eleitor){
        String dados = "eleitor->"+eleitor.getPessoaNome()+":"
                +eleitor.getPessoaCpf()+":"
                +eleitor.getDataNascimentoString();
        return dados.hashCode();
    }
}
