package br.com.dev.estoque.demo.controller;

import br.com.dev.estoque.demo.model.*;
import br.com.dev.estoque.demo.model.util.Contato;
import br.com.dev.estoque.demo.model.util.Endereco;
import br.com.dev.estoque.demo.repository.ItemEstocadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("item_estocado")
public class ItemEstocadoController {


    private final ItemEstocadoRepository itemEstocadoDAO;

    @Autowired
    public ItemEstocadoController(ItemEstocadoRepository itemEstocadoDAO) {
        this.itemEstocadoDAO = itemEstocadoDAO;

    }

    @GetMapping
    public String getItemEstocadoPage(Model model) {
        // Query realizada no BD (ItemEstocado.java)
        // model.addAttribute retorna uma lista de Itens Estocados
        model.addAttribute("itens_estocados", itemEstocadoDAO.findAll());
        return "item_estocado";
    }

}
