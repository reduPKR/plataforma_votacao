package br.com.candidato.candidato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoEntity, Long> {
    Optional<CandidatoEntity> findByCodigoCandidato(String codigo);
}
