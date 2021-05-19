package br.com.dev.estoque.demo.controller_test;

import br.com.dev.estoque.demo.controller.ClienteController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ClienteControllerTeste {
    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void test() {

    }
}
