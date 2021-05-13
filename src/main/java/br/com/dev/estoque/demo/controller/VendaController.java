package br.com.dev.estoque.demo.controller;

import br.com.dev.estoque.demo.model.Venda;
import br.com.dev.estoque.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("venda")
public class VendaController {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaController(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @GetMapping
    public String getVendaPage() {
        return "venda";
    }

    @GetMapping("cadastro")
    public String getVendaCadastroPage(@ModelAttribute Venda venda,Model model) {

        return "venda_cadastro";
    }

    @PostMapping
    public String saveVenda(@ModelAttribute Venda venda) {

        return "redirect:/venda";
    }
}
