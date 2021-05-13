package br.com.dev.estoque.demo.model.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Contato {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String telefoneCelular;
    private String telefoneFixo;

}
