package br.com.dev.estoque.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Cliente {

    @Id @GeneratedValue
    private Long id;

    private String nome;
    private String CPF;
    private String RG;


//    private List<Contato> contatos;

}
