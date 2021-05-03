package br.com.dev.estoque.demo.repository;

import br.com.dev.estoque.demo.model.Fornecedor;
import br.com.dev.estoque.demo.model.Mercadoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {
//    @Query("Select a from FORNECEDOR where lower() like lower()")
    List<Fornecedor> findByNomeFantasiaContainingIgnoreCase(String nomeFantasia);
    List<Fornecedor> findByRazaoSocialContainingIgnoreCase(String razaoSocial);
    List<Fornecedor> findByEmailContainingIgnoreCase(String email);
}
