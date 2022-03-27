package br.com.eleitor.eleitor;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public String getDataNascimentoString() {
        return pessoa.getDataNascimento().toString();
    }
}
