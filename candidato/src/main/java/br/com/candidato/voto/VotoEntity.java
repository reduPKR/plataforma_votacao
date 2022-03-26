package br.com.candidato.voto;

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
    private  boolean eleitor;
    @Column
    private boolean candidato;
    @Basic
    private LocalDate data;

    public void aprovaCandidato() {
        this.candidato = true;
    }
}
