package br.com.dev.estoque.demo.selenium;

import br.com.dev.estoque.demo.creators_util.ClienteCreator;
import br.com.dev.estoque.demo.model.Cliente;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class SeleniumTest {
    private static WebDriver firefoxDriver;

    @BeforeClass
    public static void setup() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/home/takae/Downloads/geckodriver");
        firefoxDriver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        firefoxDriver.quit();
    }

    @Before
    public void setUp() throws Exception {
        firefoxDriver.get("about:config");
    }

    @Test
    public void isClientePageAccessibleTest() {
        firefoxDriver.get("localhost:8080/cliente");
        Assertions.assertThat(firefoxDriver.getTitle()).isEqualTo("Clientes");
    }

    @Test
    public void save_PersistClienteInClientePage_WhenSuccessful() {
        String nome = "Lucas da Silva Rodrigues";
        String cpf = "227.246.460-29";
        String rg = "34.262.347-3";
        firefoxDriver.get("localhost:8080/cliente/cadastro");
        firefoxDriver.findElement(By.id("nome")).sendKeys(nome);
        firefoxDriver.findElement(By.id("cpf")).sendKeys(cpf);
        firefoxDriver.findElement(By.id("RG")).sendKeys(rg);
        firefoxDriver.findElement(By.id("cadastra_cliente_btn")).click();
        firefoxDriver.get("localhost:8080/cliente");
        var tabela = firefoxDriver.findElement(By.id("clientes"));
        var linhas = tabela.findElements(By.cssSelector("tr"));
        // Remove a linha do Header
        linhas.remove(0);
        boolean isPresent = false;
        for(var linha : linhas) {
            var dados = linha.findElements(By.cssSelector("td"));
            if(dados.get(1).getText().equals(cpf)
               && dados.get(2).getText().equals(rg)
               && dados.get(3).getText().equals(nome)) {
                isPresent = true;
            }
        }
        Assertions.assertThat(isPresent).isTrue();
    }

    @Test
    public void isFornecedorPageAccessibleTest() {
        firefoxDriver.get("localhost:8080/fornecedor");
        Assertions.assertThat(firefoxDriver.getTitle()).isEqualTo("Fornecedores");
    }







}
