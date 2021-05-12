package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.ItemEstocado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEstocadoRepository extends CrudRepository<ItemEstocado, Long> {
}
