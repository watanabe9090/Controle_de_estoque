package br.com.dev.estoque.demo.model.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Contato {
    @Id @GeneratedValue
    private long id;
    private String telefoneCelular;
    private String telefoneFixo;

}
