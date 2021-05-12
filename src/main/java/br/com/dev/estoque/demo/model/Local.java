package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Local implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String cep;
    private String setor;
    private String capacidade;

}
