package br.com.dev.estoque.demo.controller;


import br.com.dev.estoque.demo.model.Fornecedor;
import br.com.dev.estoque.demo.model.Mercadoria;
import br.com.dev.estoque.demo.model.util.Contato;
import br.com.dev.estoque.demo.model.util.Endereco;
import br.com.dev.estoque.demo.repository.FornecedorRepository;
import br.com.dev.estoque.demo.repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "mercadoria")
public class MercadoriaController {

    private final MercadoriaRepository mercadoriaDAO;

    @Autowired
    public MercadoriaController(MercadoriaRepository mercadoriaDAO) {
        this.mercadoriaDAO = mercadoriaDAO;
        this.mercadoriaDAO.save(new Mercadoria(100,
                new Fornecedor(10, "Marcos", "ChurrosM", "marcosemai@ghotma", "microemprendedor",
                        new Contato(123,"91111-4444", "1234-5678"),
                        new Endereco(12903, "AKSDH", "asdas d", "asd ads ", "1231 ", "020-9239")
                ), "ChurrosA", "ROyalChurros", "CHurros do bão")
        );

    }


    @GetMapping
    public String getMercadoriaPage(Model model) {
        model.addAttribute("mercadorias", mercadoriaDAO.findAll());
        return "mercadoria";
    }

    @GetMapping(path = "cadastro")
    public String getMercadoriaCadastroPage(@ModelAttribute Mercadoria mercadoria) {
        return "mercadoria_cadastro";
    }

    @PostMapping("cadastro/save")
    public String saveMercadoria(@ModelAttribute Mercadoria mercadoria) {
        System.out.println(mercadoria.toString());
        mercadoriaDAO.save(mercadoria);
        return "mercadoria_cadastro";
    }
}
