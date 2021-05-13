package br.com.dev.estoque.demo.controller;

import br.com.dev.estoque.demo.model.Fornecedor;
import br.com.dev.estoque.demo.model.ItemEstocado;
import br.com.dev.estoque.demo.model.Venda;
import br.com.dev.estoque.demo.repository.ClienteRepository;
import br.com.dev.estoque.demo.repository.ItemEstocadoRepository;
import br.com.dev.estoque.demo.repository.ItemVendidoRepository;
import br.com.dev.estoque.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("venda")
public class VendaController {

    private final VendaRepository vendaRepository;
    private final ItemEstocadoRepository itemEstocadoRepository;
    private final ItemVendidoRepository itemVendidoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public VendaController(VendaRepository vendaRepository, ClienteRepository clienteRepository, ItemEstocadoRepository itemEstocadoRepository, ItemVendidoRepository itemVendidoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.itemEstocadoRepository = itemEstocadoRepository;
        this.itemVendidoRepository = itemVendidoRepository;
    }

    @GetMapping
    public String getVendaPage(Model model) {
        model.addAttribute("vendas", vendaRepository.findAll());
        return "venda";
    }

    @GetMapping("cadastro")
    public String getVendaCadastroPage(@ModelAttribute Venda venda, Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("itens_estocados", itemEstocadoRepository.findAll());
        return "venda_cadastro";
    }

    @GetMapping("detalhe/{id}")
    public String getVendaDetalahmentoPage(@PathVariable("id") long id, Model model) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        model.addAttribute("venda", venda);
        model.addAttribute("itens_vendidos", venda.getItemVendidos());
        return "venda_detalhe";
    }

    @PostMapping("cadastro/save")
    public String saveVenda(@ModelAttribute Venda venda) {
        venda.setDataVenda(LocalDateTime.now());
        vendaRepository.save(venda);
        return "redirect:/venda";
    }
}