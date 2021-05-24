package br.com.dev.estoque.demo.service;

import br.com.dev.estoque.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Component
public class DatabaseInitializationService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ClienteRepository clienteRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        if(clienteRepository.findById(Long.valueOf(1)).isEmpty() ) {
            ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("data.sql"));
            resourceDatabasePopulator.execute(dataSource);
        }
    }

}
