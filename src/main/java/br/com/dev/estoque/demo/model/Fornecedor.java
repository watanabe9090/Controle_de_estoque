package br.com.dev.estoque.demo.model;


import br.com.dev.estoque.demo.model.util.Contato;
import br.com.dev.estoque.demo.model.util.Endereco;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Fornecedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String razaoSocial;
    private String nomeFantasia;
    private String email;
    private String descricao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato", referencedColumnName = "id")
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    private Endereco endereco;
}
