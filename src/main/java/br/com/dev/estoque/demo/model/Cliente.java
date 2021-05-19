package br.com.dev.estoque.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do cliente não pode estar vazio")
    @NotNull
    private String nome;

    @NotEmpty
    @NotNull
    @Size(min = 14, max = 14)
    private String CPF;

    @NotEmpty
    @NotNull
    @Size(min = 12, max = 12)
    private String RG;

}
