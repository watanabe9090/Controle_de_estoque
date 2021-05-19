package br.com.dev.estoque.demo.repository_test;

import br.com.dev.estoque.demo.creators_util.ClienteCreator;
import br.com.dev.estoque.demo.model.Cliente;
import br.com.dev.estoque.demo.repository.ClienteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Testes Unitários para o Cliente")
public class ClienteTest {

    private final ClienteRepository clienteRepository;


    @Autowired
    public ClienteTest(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Esta seção está caracterizada pelos
     * testes de CRUD no banco de dados, com
     * basae nas classes ClienteRepository e
     * Cliente(que se refere a classe model)
     */

    @Test
    @DisplayName("Save: Salva um cliente válido cliente ")
    public void save_PersistsCliente_WhenSuccessful() {
        Cliente clienteToBeSaved = ClienteCreator.createValidCliente();
        Cliente clienteSaved = this.clienteRepository.save(clienteToBeSaved);
        Assertions.assertThat(clienteSaved).isNotNull();
        Assertions.assertThat(clienteSaved.getId()).isNotNull();
        Assertions.assertThat(clienteSaved.getNome()).isEqualTo(clienteToBeSaved.getNome());
    }

    @Test
    @DisplayName("Update: Atualiza um cliente válido com um nome válido")
    public void save_UpdatesCliente_WhenSuccessful() {
        Cliente clienteToBeSaved = ClienteCreator.createValidCliente();
        Cliente clienteSaved = this.clienteRepository.save(clienteToBeSaved);
        clienteSaved.setNome("João Ribeiro");
        Cliente clienteUpdated = this.clienteRepository.save(clienteSaved);

        Assertions.assertThat(clienteUpdated).isNotNull();
        Assertions.assertThat(clienteUpdated.getId()).isNotNull();
        Assertions.assertThat(clienteUpdated.getNome()).isEqualTo(clienteSaved.getNome());
    }


    @Test
    @DisplayName("Delete: Remove um cliente válido")
    public void delete_RemovesCliente_WhenSuccessful() {
        Cliente clienteToBeSaved = ClienteCreator.createValidCliente();
        Cliente clienteSaved = this.clienteRepository.save(clienteToBeSaved);

        this.clienteRepository.delete(clienteSaved);
        Optional<Cliente> clienteOptional = this.clienteRepository.findById(clienteSaved.getId());
        Assertions.assertThat(clienteOptional).isEmpty();
    }

    @Test
    @DisplayName("Find: Procura clientes pelo paramentro 'nome' por uma string e retorna uma lista de Cliente")
    public void findByName_ReturnsListOfCliente_WhenSuccessful() {
        Cliente clienteToBeSaved = ClienteCreator.createValidCliente();
        Cliente clienteSaved = this.clienteRepository.save(clienteToBeSaved);
        String nome = clienteSaved.getNome();

        List<Cliente> clienteList = this.clienteRepository.findByNomeContainingIgnoreCase(nome);
        Assertions.assertThat(clienteList).isNotEmpty();
        Assertions.assertThat(clienteList).contains(clienteSaved);

    }

    @Test
    @DisplayName("Find: Procura clientes pelo paramentro 'nome' por uma string e retorna uma lista Vazia")
    public void findByName_ReturnsEmptyListOfCliente_WhenClienteIsNotFound() {
        String nome = "This is a cliente nome who cannot be found";
        List<Cliente> clienteList = this.clienteRepository.findByNomeContainingIgnoreCase(nome);
        Assertions.assertThat(clienteList).isEmpty();
    }

    @Test
    @DisplayName("Find: Procura um cliente pelo paramentro 'CPF' por uma string e retorna um cliente com determinado cpf existir")
    public void findByCPF_ReturnsCliente_WhenSuccessful() {
        Cliente clienteToBeSaved = ClienteCreator.createValidCliente();
        Cliente clienteSaved = this.clienteRepository.save(clienteToBeSaved);
        String cpf = clienteSaved.getCPF();

        Cliente clienteToBeFinded = this.clienteRepository.findByCPF(cpf);
        Assertions.assertThat(clienteToBeFinded).isEqualTo(clienteSaved);
    }

    /**
     * Está seção se responsabiliza pelos
     * testes dos atributos caso estejam
     * vazios
     */

    @Test
    @DisplayName("save: Joga uma exceção de 'ConstraintViolationException' quando o campo 'nome' está vazio")
    public void save_ThrowsConstraintViolationException_WhenNameIsEmpty() {
        Cliente cliente = ClienteCreator.createEmptyCliente(false, true, true);
        Assertions.assertThatThrownBy(() -> this.clienteRepository.save(cliente))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("save: Joga uma exceção de 'ConstraintViolationException' quando o campo 'CPF' está vazio")
    public void save_ThrowsConstraintViolationException_WhenCPFIsEmpty() {
        Cliente cliente = ClienteCreator.createEmptyCliente(true, false, false);
        Assertions.assertThatThrownBy(() -> this.clienteRepository.save(cliente))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("save: Joga uma exceção de 'ConstraintViolationException' quando o campo 'RG' está vazio")
    public void save_ThrowsConstraintViolationException_WhenRGIsEmpty() {
        Cliente cliente = ClienteCreator.createEmptyCliente(false, false, true);
        Assertions.assertThatThrownBy(() -> this.clienteRepository.save(cliente))
                .isInstanceOf(ConstraintViolationException.class);
    }

    /**
     * Está seção se responsabiliza pelos
     * testes dos atributos caso estejam
     * nulos
     */

    @Test
    @DisplayName("save: Joga uma exceção de 'ConstraintViolationException' quando o campo 'nome' está nulo")
    public void save_ThrowsConstraintViolationException_WhenNomeIsNull() {
        Cliente cliente = ClienteCreator.createNullCliente(true, false, false);
        Assertions.assertThatThrownBy(() -> this.clienteRepository.save(cliente))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("save: Joga uma exceção de 'ConstraintViolationException' quando o campo 'CPF' está nulo")
    public void save_ThrowsConstraintViolationException_WhenCPFIsNull() {
        Cliente cliente = ClienteCreator.createNullCliente(false, true, false);
        Assertions.assertThatThrownBy(() -> this.clienteRepository.save(cliente))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("save: Joga uma exceção de 'ConstraintViolationException' quando o campo 'RG' está nulo")
    public void save_ThrowsConstraintViolationException_WhenRGIsNull() {
        Cliente cliente = ClienteCreator.createNullCliente(false, false, true);
        Assertions.assertThatThrownBy(() -> this.clienteRepository.save(cliente))
                .isInstanceOf(ConstraintViolationException.class);
    }
}