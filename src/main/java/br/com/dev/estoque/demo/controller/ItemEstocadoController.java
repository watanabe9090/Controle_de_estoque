package br.com.dev.estoque.demo.controller;

import br.com.dev.estoque.demo.repository.ItemEstocadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item_estocado")
public class ItemEstocadoController {

    private final ItemEstocadoRepository repositoryDAO;

    @Autowired
    public ItemEstocadoController(ItemEstocadoRepository repositoryDAO) {
        this.repositoryDAO = repositoryDAO;

    }

    @GetMapping
    public String getItemEstocadoPage(Model model) {
        // Query realizada no BD (ItemEstocado.java)
        // model.addAttribute retorna uma lista de Itens Estocados
        model.addAttribute("itens_estocados", repositoryDAO.findAll());
        return "item_estocado";
    }

}
