package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Mercadoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoriaRepository extends CrudRepository<Mercadoria, Long> {
}
