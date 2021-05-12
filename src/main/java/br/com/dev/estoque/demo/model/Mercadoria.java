package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Mercadoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor", referencedColumnName = "id")
    private Fornecedor fornecedor;

    private String nome;
    private String marca;
    private String descricao;



}
