package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
}
