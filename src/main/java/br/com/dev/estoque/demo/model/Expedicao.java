package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Expedicao {

    @Id @GeneratedValue
    private long id;

    private LocalDateTime dataExpedicao;
    private double valor;

    @OneToMany
    private List<Mercadoria> mercadorias;

}
