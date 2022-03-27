package com.votacao.urna.votacao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "voto")
public class VotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String codigoCandidato;
    @Column
    private  boolean eleitor = false;
    @Column
    private boolean candidato = false;
    @Basic
    private LocalDate data = LocalDate.now();

    public VotoEntity(String codigoCandidato) {
        this.codigoCandidato = codigoCandidato;
    }
}
