package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class ItemVendido {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "item_estocado", referencedColumnName = "id")
    private ItemEstocado itemEstocado;

    @ManyToOne
    @JoinColumn(name = "venda")
    private Venda venda;

    private double precoVenda;
    private int quantidade;
}
