package br.com.dev.estoque.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("expedicao")
public class ExpedicaoController {

    @GetMapping
    public String getExpedicaoPage() {
        return "expedicao";
    }
}
