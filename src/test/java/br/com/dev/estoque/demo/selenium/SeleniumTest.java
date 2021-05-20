package br.com.dev.estoque.demo.selenium;

import br.com.dev.estoque.demo.creators_util.ClienteCreator;
import br.com.dev.estoque.demo.model.Cliente;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

public class SeleniumTest {

    protected static WebDriver firefoxDriver;
    protected final String localhost = "localhost:8090";

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








}
