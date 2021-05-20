package br.com.dev.estoque.demo.service;

import br.com.dev.estoque.demo.model.Cliente;
import br.com.dev.estoque.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public List<Cliente> findByNomeContainingIgnoreCase(String nome) {
        return this.clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
//
//    public Cliente save(Cliente clienteToBeSaved) {
//        clienteRepository.findByCPF(clienteToBeSaved.getCPF());
//    }


}
