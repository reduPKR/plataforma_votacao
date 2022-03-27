package com.votacao.urna.votacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<VotoEntity, Long> {
    Optional<List> findByDataOrderByCodigoCandidato(LocalDate now);
}
