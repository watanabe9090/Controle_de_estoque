package br.com.dev.estoque.demo.controller;

import br.com.dev.estoque.demo.model.Fornecedor;
import br.com.dev.estoque.demo.repository.FornecedorRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "fornecedor")
public class FornecedorController {

    private final FornecedorRepository fornecedorDAO;

    @Autowired
    public FornecedorController(FornecedorRepository fornecedorDAO) {
        this.fornecedorDAO = fornecedorDAO;
        this.fornecedorDAO.save(new Fornecedor(10, "Marcos", "ChurrosM", "marcosemai@ghotma", "microemprendedor"));
        this.fornecedorDAO.save(new Fornecedor(10, "Marcos", "ChurrosA", "marcosemai@ghotma", "microemprendedor"));
        this.fornecedorDAO.save(new Fornecedor(10, "Marcos", "ChurrosAA", "marcosemai@ghotma", "microemprendedor"));
        this.fornecedorDAO.save(new Fornecedor(10, "Marcos", "ChurrosAB", "marcosemai@ghotma", "microemprendedor"));
        this.fornecedorDAO.save(new Fornecedor(10, "Marcos", "ChurrosABB", "marcosemai@ghotma", "microemprendedor"));
        this.fornecedorDAO.save(new Fornecedor(10, "Marcos", "ChurrosAAAAB", "marcosemai@ghotma", "microemprendedor"));

    }

    @GetMapping
    public String getFornecedorByNomeFantasia(@RequestParam Optional<String> nomeFantasia, Model model) {
        if(!nomeFantasia.isPresent()) {
            model.addAttribute("fornecedores", this.fornecedorDAO.findAll());
            return "fornecedor";
        } else {
            model.addAttribute("fornecedores", fornecedorDAO.findByNomeFantasiaContainingIgnoreCase(nomeFantasia.get()));
            return "fornecedor";
        }
    }


    @GetMapping(path = "cadastro")
    public String getFornecedorCadastroPage(@ModelAttribute Fornecedor fornecedor) {
        return "fornecedor_cadastro";
    }


    @PostMapping("cadastro/save")
    public String saveFornecedor(@ModelAttribute Fornecedor fornecedor,  BindingResult result, Model model) {
        System.out.println(fornecedor.toString());
        fornecedorDAO.save(fornecedor);
        return "redirect:/fornecedor";
    }
    /*
    *   Seção para atualização do fornecedor
    */
    @GetMapping("edit/{id}")
    public String getEditFornecedorPage(@PathVariable("id") long id, Model model) {
        Fornecedor fornecedor = fornecedorDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor_alterar";
    }

    @PostMapping("edit/{id}")
    public String editFornecedor(@PathVariable("id") long id, Fornecedor fornecedor, BindingResult result, Model model) {
        if(result.hasErrors()) {
            fornecedor.setId(id);
            return "fornecedor_alterar";
        }
        fornecedorDAO.save(fornecedor);
        return "redirect:/fornecedor";
    }


    /*
     *   Seção para deleção do fornecedor
     */
    @GetMapping("delete/{id}")
    public String deleteFornecedor(@PathVariable("id") long id, Model model) {
        Fornecedor fornecedor = fornecedorDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        fornecedorDAO.delete(fornecedor);
        return "redirect:/fornecedor";
    }
}
