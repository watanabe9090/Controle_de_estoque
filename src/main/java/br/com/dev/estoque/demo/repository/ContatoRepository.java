package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.util.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long> {
    List<Contato> findByTelefoneCelularContaining(String telefoneCelular);
    List<Contato> findByTelefoneFixoContaining(String telefoneFixo);
}
