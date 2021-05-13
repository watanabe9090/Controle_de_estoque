package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class ItemVendido {

    @Id @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_estocado", referencedColumnName = "id")
    private ItemEstocado itemEstocado;

//    private double precoVenda;
    private int quantidade;
}
