package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Venda {

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private Cliente cliente;

    private LocalDateTime dataExpedicao;
    private double valor;



}
