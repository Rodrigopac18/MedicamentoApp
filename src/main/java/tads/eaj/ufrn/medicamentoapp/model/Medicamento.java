package tads.eaj.ufrn.medicamentoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import tads.eaj.ufrn.medicamentoapp.message.Mensagem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Size(min = 3, max = 25, message = Mensagem.ERRO_TAMANHO_TEXTO)
    String nome;
    String dosagem;
    @Size(min = 3, max = 25, message = Mensagem.ERRO_TAMANHO_TEXTO)
    String classificacao;
    Double preco;
    //Date Deleted = null;
    String imagemUri;
}
