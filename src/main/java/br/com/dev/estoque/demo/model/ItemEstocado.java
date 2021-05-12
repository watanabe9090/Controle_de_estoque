package br.com.dev.estoque.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class ItemEstocado {
    @Id @GeneratedValue
    private long id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "mercadoria", referencedColumnName = "id")
    private Mercadoria mercadoria;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote", referencedColumnName = "id")
    public Lote lote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local", referencedColumnName = "id")
    public Local local;

    public int quantidade;
}
