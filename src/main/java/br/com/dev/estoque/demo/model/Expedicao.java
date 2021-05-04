package br.com.dev.estoque.demo.model;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Expedicao {

    private long id;
    private Date dataExpedicao;
    private double valor;

    @OneToMany
    private List<Mercadoria> mercadorias;
}
