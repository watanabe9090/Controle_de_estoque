package br.com.dev.estoque.demo.selenium;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FornecedorSeleniumTest extends SeleniumTest{

    @Test
    public void isFornecedorPageAccessibleTest() {
        firefoxDriver.get(localhost + "/fornecedor");
        Assertions.assertThat(firefoxDriver.getTitle()).isEqualTo("Fornecedores");
    }

}
