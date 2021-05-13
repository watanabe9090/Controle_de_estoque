package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.ItemVendido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendidoRepository extends CrudRepository<ItemVendido, Long> {
}
