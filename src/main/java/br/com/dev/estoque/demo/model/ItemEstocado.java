package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class ItemEstocado implements Serializable {
    @Id @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mercadoria", referencedColumnName = "id")
    private Mercadoria mercadoria;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lote", referencedColumnName = "id")
    private Lote lote;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "local", referencedColumnName = "id")
    private Local local;

    private double precoCompra;
    private double precoVenda;
    private int quantidade;
}
