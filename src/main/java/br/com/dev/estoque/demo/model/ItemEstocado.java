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

    @ManyToOne
    @JoinColumn(name = "mercadoria", referencedColumnName = "id")
    private Mercadoria mercadoria;


    @ManyToOne
    @JoinColumn(name = "lote", referencedColumnName = "id")
    private Lote lote;

//    @JoinColumn(name = "local", referencedColumnName = "id")
    @ManyToOne
    @JoinColumn(name = "local")
    private Local local;

    private int quantidade;
}
