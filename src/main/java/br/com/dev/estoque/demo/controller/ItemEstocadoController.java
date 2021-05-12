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
////        private long id;
////        private Mercadoria mercadoria;
////        public Lote lote;
////        public Local local;
////        public int quantidade;
//        Mercadoria mercadoria = new Mercadoria(1,
//                new Fornecedor(10, "Marcos", "ChurrosM", "marcosemai@ghotma", "microemprendedor",
//                        new Contato(123, "91111-4444", "1234-5678"),
//                        new Endereco(12903, "AKSDH", "asdas d", "asd ads ", "1231 ", "020-9239")
//                ),"Ração Magnus Adulto Frango", "Margnus", "Frango Adulto");
//        Lote lote = new Lote(1, LocalDate.now(), LocalDate.of(2022, 10, 2));
        Local local = new Local(12,"54160-425", "m", "40");

//        this.itemEstocadoDAO.save(new ItemEstocado(1, mercadoria, lote, local, 20));
        this.itemEstocadoDAO.save(new ItemEstocado(10, local,20));
    }

    @GetMapping
    public String getItemEstocadoPage(Model model) {
        // Query realizada no BD (ItemEstocado.java)
        // model.addAttribute retorna uma lista de Itens Estocados
        model.addAttribute("itens_estocados", itemEstocadoDAO.findAll());
        return "item_estocado";
    }

}
