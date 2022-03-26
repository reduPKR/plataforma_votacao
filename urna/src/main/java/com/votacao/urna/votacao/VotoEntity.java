package com.votacao.urna.votacao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "voto")
public class VotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private  boolean eleitor = false;
    @Column
    private boolean candidato = false;
    @Basic
    private LocalDate data = LocalDate.now();
}
