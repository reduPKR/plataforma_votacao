package br.com.eleitor.eleitor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EleitorRepository extends JpaRepository<EleitorEntity, Long> {
    Optional<EleitorEntity> findByCodigoValidacao(String codigoEleitor);
}
