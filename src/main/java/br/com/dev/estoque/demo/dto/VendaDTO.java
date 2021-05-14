package br.com.dev.estoque.demo.dto;

import br.com.dev.estoque.demo.model.ItemEstocado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {

    private Integer id;
    private Integer clienteId;
    private Integer quantidade;
    private ItemEstocado itemEstocado;

}
