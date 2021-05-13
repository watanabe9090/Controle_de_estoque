package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Lote implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFabricacao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;
}
