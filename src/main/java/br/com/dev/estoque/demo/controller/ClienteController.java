package br.com.dev.estoque.demo.controller;


import br.com.dev.estoque.demo.model.Cliente;
import br.com.dev.estoque.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cliente")
public class ClienteController {
    private final ClienteRepository clienteDAO;

    @Autowired
    public ClienteController(ClienteRepository clienteDAO) {
        this.clienteDAO = clienteDAO;
        this.clienteDAO.save(new Cliente(1, "Jorge","999999999-99","053623264-25" ));
    }

    @GetMapping
    public String getClientePage(Model model) {
        model.addAttribute("clientes",clienteDAO.findAll());
        return "cliente";
    }

    @GetMapping(path = "cadastro")
    public String getClienteCadastroPage(@ModelAttribute Cliente cliente){
        return "cliente_cadastro";
    }

    @PostMapping("cadastro/save")
    public String saveCliente(@ModelAttribute Cliente cliente){
        clienteDAO.save(cliente);
        return "cliente_cadastro";
    }

}
