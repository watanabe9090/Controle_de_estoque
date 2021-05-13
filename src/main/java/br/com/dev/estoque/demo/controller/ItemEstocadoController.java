package br.com.dev.estoque.demo.controller;

import br.com.dev.estoque.demo.model.*;
import br.com.dev.estoque.demo.repository.FornecedorRepository;
import br.com.dev.estoque.demo.repository.ItemEstocadoRepository;
import br.com.dev.estoque.demo.repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("item_estocado")
public class ItemEstocadoController {


    private final ItemEstocadoRepository itemEstocadoDAO;
    private final MercadoriaRepository mercadoriaDAO;
    private final FornecedorRepository fornecedorDAO;

    @Autowired
    public ItemEstocadoController(ItemEstocadoRepository itemEstocadoDAO, FornecedorRepository fornecedorDAO, MercadoriaRepository mercadoriaDAO) {
        this.itemEstocadoDAO = itemEstocadoDAO;
        this.mercadoriaDAO = mercadoriaDAO;
        this.fornecedorDAO = fornecedorDAO;
    }



    @GetMapping
    public String getItemEstocadoPage(Model model) {
        // Query realizada no BD (ItemEstocado.java)
        // model.addAttribute retorna uma lista de Itens Estocados
        model.addAttribute("itens_estocados", itemEstocadoDAO.findAll());
        return "item_estocado";
    }

    @GetMapping("cadastro")
    public String getCadastroItemEstocadoPage(@ModelAttribute ItemEstocado itemEstocado, Model model) {
        model.addAttribute("fornecedores", fornecedorDAO.findAll());
        return "item_estocado_cadastro";
    }


    @PostMapping("cadastro/save")
    public String saveItemEstocado(@ModelAttribute ItemEstocado itemEstocado, BindingResult result, Model model) {
        System.out.println(itemEstocado.toString());
        itemEstocadoDAO.save(itemEstocado);
        return "redirect:/item_estocado";
    }



    @GetMapping("edit/{id}")
    public String getEditItemEstocadoPage(@PathVariable("id") long id, Model model) {
        ItemEstocado itemEstocado = itemEstocadoDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        model.addAttribute("item_estocado", itemEstocado);
        return "item_estocado_alterar";
    }

    @PostMapping("edit/{id}")
    public String editItemEstocado(@PathVariable("id") long id, ItemEstocado itemEstocado, BindingResult result, Model model) {
        if(result.hasErrors()) {
            itemEstocado.setId(id);
            return "fornecedor_alterar";
        }
        itemEstocadoDAO.save(itemEstocado);
        return "redirect:/item_estocado";
    }





    @GetMapping("delete/{id}")
    public String deleteItemEstocado(@PathVariable("id") long id, Model model) {
        ItemEstocado itemEstocado = itemEstocadoDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        itemEstocadoDAO.delete(itemEstocado);
        return "redirect:/item_estocado";
    }
}
