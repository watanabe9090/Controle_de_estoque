package br.com.dev.estoque.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class ItemVendido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "item_estocado", referencedColumnName = "id")
    private ItemEstocado itemEstocado;

    @ManyToOne
    @JoinColumn(name = "venda", referencedColumnName = "id")
    private Venda venda;

    private double precoVenda;
    private int quantidade;
}
