package br.com.dev.estoque.demo.controller;


import br.com.dev.estoque.demo.model.Cliente;
import br.com.dev.estoque.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public String getClientePage(@RequestParam Optional<String> nome, Model model) {
        if(nome.isPresent()) {
            model.addAttribute("clientes", this.clienteRepository.findByNomeContainingIgnoreCase(nome.get()));
        }else {
            model.addAttribute("clientes", clienteRepository.findAll());
        }
        return "cliente";
    }

    @GetMapping(path = "cadastro")
    public String getClienteCadastroPage(@ModelAttribute Cliente cliente){
        return "cliente_cadastro";
    }

    @PostMapping("cadastro/save")
    public String saveCliente(@ModelAttribute @Valid Cliente cliente, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {

        }
        System.out.println(clienteRepository.save(cliente));
        return "redirect:/cliente";
    }

}
