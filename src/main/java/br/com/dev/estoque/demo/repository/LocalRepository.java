package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Local;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends CrudRepository<Local, Long> {
}
