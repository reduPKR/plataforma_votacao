package com.votacao.urna.pessoa.eleitor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EleitorRepository extends JpaRepository<EleitorEntity, Long> {
}
