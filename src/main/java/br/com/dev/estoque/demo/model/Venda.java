package br.com.dev.estoque.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Venda {

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<ItemVendido> itensVendidos = new ArrayList<>();

    private LocalDateTime dataVenda;
    private double valor;



}
