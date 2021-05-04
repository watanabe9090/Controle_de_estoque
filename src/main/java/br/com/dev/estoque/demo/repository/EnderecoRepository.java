package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.util.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
}
