package br.com.candidato.voto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Voto {
    private long id;
    private String cpfEleitor;
    private  long codigoEleitor;
    private String codidoCanditado;
}
