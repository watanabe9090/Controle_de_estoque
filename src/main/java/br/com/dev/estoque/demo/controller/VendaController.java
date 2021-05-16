package br.com.dev.estoque.demo.controller;

import br.com.dev.estoque.demo.model.Fornecedor;
import br.com.dev.estoque.demo.model.ItemEstocado;
import br.com.dev.estoque.demo.model.ItemVendido;
import br.com.dev.estoque.demo.model.Venda;
import br.com.dev.estoque.demo.repository.ClienteRepository;
import br.com.dev.estoque.demo.repository.ItemEstocadoRepository;
import br.com.dev.estoque.demo.repository.ItemVendidoRepository;
import br.com.dev.estoque.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        List<ItemEstocado> itemEstocados = itemEstocadoRepository.findAll();
//        venda.setItensVendidos(new ArrayList<>()); ;
        Map<Long, ItemEstocado> itemEstocadosMap = itemEstocados.stream().collect(Collectors.toMap(i -> i.getId(), item -> item));
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("itens_estocados", itemEstocadosMap);
        return "venda_cadastro";
    }


    @PostMapping("cadastro/save")
    @Transactional
    public String saveVenda(@ModelAttribute Venda venda) {
        venda.setDataVenda(LocalDateTime.now());
        // Salva as quantias retiradas
        for(ItemVendido itemVendido :venda.getItensVendidos()) {
            ItemEstocado itemEstocado = itemVendido.getItemEstocado();
            itemEstocado.setQuantidade(itemEstocado.getQuantidade() - itemVendido.getQuantidade());
            itemEstocadoRepository.save(itemEstocado);
        }
        vendaRepository.save(venda);

        venda.getItensVendidos()
                .forEach(itemVendido -> itemVendido.setVenda(venda));

        //System.out.println(venda.toString());
        return "redirect:/venda";
    }



    @GetMapping("detalhe/{id}")
    public String getVendaDetalahmentoPage(@PathVariable("id") long id, Model model) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        model.addAttribute("venda", venda);
        model.addAttribute("itens_vendidos", venda.getItensVendidos());
        return "venda_detalhe";
    }

}
