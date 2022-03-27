package br.com.eleitor.voto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VotoService {
    @Autowired
    private VotoRepository votoRepository;

    public List lista(){
        List list = votoRepository.findAll();
        VotoMapper votoMapper = new VotoMapper();
        return votoMapper.toResponse(list);
    }

    public void aprovar(Voto voto) {
        Optional<VotoEntity> optional = votoRepository.findById(voto.getId());

        if(optional.isPresent()){
            VotoEntity entity = optional.get();
            entity.aprovaEleitor();
            votoRepository.save(entity);
        }else {
            System.out.println("------------> ocorreu um erro  <------------");
        }

    }
}
