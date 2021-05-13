package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
//    List<Expedicao> findExpedicaoByDataExpedicao();
}
