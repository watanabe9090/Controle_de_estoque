package br.com.dev.estoque.demo.service;

import br.com.dev.estoque.demo.model.Fornecedor;
import br.com.dev.estoque.demo.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.List;

@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public void saveFornecedor(Fornecedor fornecedor) {
        // Validatioin

    }


    /*
     * Validação dos campos do fornecedor
     *
     *
     *
     *
     *  */

    public void validateTelefoneCelular() {

    }

    public void validateTelefoneFixo() {

    }

}
