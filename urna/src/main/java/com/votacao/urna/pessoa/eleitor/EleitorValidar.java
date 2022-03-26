package com.votacao.urna.pessoa.eleitor;

import com.votacao.urna.pessoa.Pessoa;
import com.votacao.urna.pessoa.PessoaEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EleitorValidar {
    private long codigoValidacao;

    private void gerarCodigo(EleitorRequest request){
        String dados = "eleitor->"+request.getNome()+":"+request.getCpf()+":"+request.getDataNascimentoString();
        codigoValidacao = dados.hashCode();
    }

    public EleitorEntity requestToEntity(EleitorRequest request){
        gerarCodigo(request);

        PessoaEntity pessoaEntity =
                new PessoaEntity(request.getNome(), request.getCpf(), request.getDataNascimento());
        return new EleitorEntity(pessoaEntity, codigoValidacao);
    }

    public EleitorResponse entityToResponse(EleitorEntity entity) {
        return new EleitorResponse(entity.getPessoaNome(), entity.getPessoaCpf(), entity.getCodigoValidacao());
    }

    public List<EleitorResponse> entityToResponse(List<EleitorEntity> entity) {
        return entity
                .stream()
                .map(item -> new EleitorResponse(item.getPessoaNome(), item.getPessoaCpf(), item.getCodigoValidacao()))
                .collect(Collectors.toList());
    }
}
