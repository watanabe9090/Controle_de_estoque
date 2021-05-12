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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "mercadoria", referencedColumnName = "id")
//    private Mercadoria mercadoria;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "lote", referencedColumnName = "id")
//    private Lote lote;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "local", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local", referencedColumnName = "id")
    private Local local;

    private int quantidade;
}
