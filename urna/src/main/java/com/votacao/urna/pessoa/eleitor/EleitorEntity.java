package com.votacao.urna.pessoa.eleitor;

import com.votacao.urna.pessoa.PessoaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "eleitor")
public class EleitorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoa;

    @NotNull
    private long codigoValidacao;

    public EleitorEntity(PessoaEntity pessoa, long codigoValidacao) {
        this.pessoa = pessoa;
        this.codigoValidacao = codigoValidacao;
    }

    public String getPessoaNome() {
        return pessoa.getNome();
    }

    public String getPessoaCpf() {
        return pessoa.getCpf();
    }
}
