package br.com.dev.estoque.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Local implements Serializable {
    @Id
    @GeneratedValue
    private long id;

//    @OneToMany
//    @JoinColumn(name = "local")
//    private List<ItemEstocado> itemEstocados;

    private String cep;
    private String setor;
    private String capacidade;

}
