package com.votacao.urna.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Long> {
    Optional<PessoaEntity> findByCpf(String cpf);
}
