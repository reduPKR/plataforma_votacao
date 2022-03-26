package br.com.candidato.candidato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "candidato")
public class CandidatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigoCandidato;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoa;

    public CandidatoEntity(String codigoCandidato) {
        this.codigoCandidato = codigoCandidato;
    }

    public String getPessoaNome() {
        return pessoa.getNome();
    }

    public String getPessoaCpf() {
        return pessoa.getCpf();
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }
}
