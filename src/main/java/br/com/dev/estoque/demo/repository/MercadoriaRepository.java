package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Mercadoria;
import org.springframework.data.repository.CrudRepository;

public interface MercadoriaRepository extends CrudRepository<Mercadoria, Long> {
}
