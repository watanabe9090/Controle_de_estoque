package br.com.dev.estoque.demo.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class VendaSeleniumTest extends SeleniumTest{

    @Test
    public void doVenda_WhenSuccessful() {
        firefoxDriver.get(localhost + "/venda/cadastro");
        firefoxDriver.findElement(By.id("btnAddMerc")).click();
        firefoxDriver.findElement(By.id("qtd15")).sendKeys("15");
    }
}
