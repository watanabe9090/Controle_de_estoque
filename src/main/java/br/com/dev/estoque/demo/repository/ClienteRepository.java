package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
