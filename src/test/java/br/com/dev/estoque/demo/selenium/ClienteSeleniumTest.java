package br.com.dev.estoque.demo.selenium;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClienteSeleniumTest extends SeleniumTest{


    @Test
    public void isClientePageAccessibleTest() {
        firefoxDriver.get(localhost + "/cliente");
        Assertions.assertThat(firefoxDriver.getTitle()).isEqualTo("Clientes");
    }

    @Test
    public void save_PersistClienteInClientePage_WhenSuccessful() throws InterruptedException {
        String nome = "Lucas da Silva Rodrigues";
        String cpfWrong = "227.246.460-49";
        String cpf = "227.246.460-29";
        String rg = "34.262.347-3";

        // Teste referente a validação do CPF, passando um cpf inválido
        firefoxDriver.get(localhost + "/cliente/cadastro");
        firefoxDriver.findElement(By.id("nome")).sendKeys(nome);
        firefoxDriver.findElement(By.id("cpf")).sendKeys(cpfWrong);
        firefoxDriver.findElement(By.id("RG")).sendKeys(rg);
        String beforeValidationUrl = firefoxDriver.getCurrentUrl();
        Thread.sleep(1000);
        firefoxDriver.findElement(By.id("cadastra_cliente_btn")).click();
        Assertions.assertThat(firefoxDriver.getCurrentUrl()).isEqualTo(beforeValidationUrl);

        /// Teste referente a validação com CPF, com um cpf válido
        firefoxDriver.findElement(By.id("cpf")).clear();
        firefoxDriver.findElement(By.id("cpf")).sendKeys(cpf);
        firefoxDriver.findElement(By.id("cadastra_cliente_btn")).click();


        firefoxDriver.get(localhost + "/cliente");
        WebElement tabela = firefoxDriver.findElement(By.id("clientes"));
        List<WebElement> linhas = tabela.findElements(By.cssSelector("tr"));
        linhas.remove(0);// Remove a linha do Header
        boolean isPresent = false;
        for(var linha : linhas) {
            var dados = linha.findElements(By.cssSelector("td"));
            if (dados.get(1).getText().equals(cpf)
                    && dados.get(2).getText().equals(rg)
                    && dados.get(3).getText().equals(nome)) {
                isPresent = true;
            }
        }
        Assertions.assertThat(isPresent).isTrue();
    }

}
