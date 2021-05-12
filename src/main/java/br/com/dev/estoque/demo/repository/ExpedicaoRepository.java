package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Expedicao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpedicaoRepository extends CrudRepository<Expedicao, Long> {
//    List<Expedicao> findExpedicaoByDataExpedicao();
}
