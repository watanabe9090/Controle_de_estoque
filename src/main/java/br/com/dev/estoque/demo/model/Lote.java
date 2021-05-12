package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Lote {
    @Id
    @GeneratedValue
    private long id;

    private LocalDate dataFabricacao;
    private LocalDate dataVencimento;
}
