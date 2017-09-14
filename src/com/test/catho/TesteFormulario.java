package com.test.catho;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFormulario {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {

		// � necess�rio informar para o Selenium a localiza��o do driver do Firefox
		// geckodriver no seu computador. Para isso, realizar o seguinte passo-a-passo:

		// 1. Acessar https://github.com/mozilla/geckodriver/releases
		// 2. Fazer o download do geckodriver e extrair o arquivo geckodriver.exe
		// 3. Substituir o PATH abaixo pelo PATH do geckodriver.exe no seu computador

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\luizc\\Desktop\\geckodriver.exe");

		driver = new FirefoxDriver();
		baseUrl = "https://www.w3schools.com/php/demo_form_validation_complete.php";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/*
	 * Teste 01: Formul�rio preenchido com sucesso | Usu�rio preenche todos os
	 * campos obrigat�rios e nos formatos corretos.
	 */
	@Test
	public void formularioPreenchidoComSucesso() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("name")).sendKeys("Luiz");
		driver.findElement(By.name("email")).sendKeys("luiz.contim@hotmail.com");
		driver.findElement(By.cssSelector("input[value='male']")).click();
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		assertFalse(driver.findElement(By.tagName("form")).getText().contains("* Name is required"));
		assertFalse(driver.findElement(By.tagName("form")).getText().contains("* Email is required"));
		assertFalse(driver.findElement(By.tagName("form")).getText().contains("* Invalid email format"));
		assertFalse(driver.findElement(By.tagName("form")).getText().contains("* Gender is required"));
	}

	/*
	 * Teste 02: Nome em branco | Usu�rio n�o preenche nome e aparece mensagem de
	 * erro
	 */
	@Test
	public void nomeEmBranco() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("email")).sendKeys("luiz.contim@hotmail.com");
		driver.findElement(By.cssSelector("input[value='male']")).click();
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		assertTrue(driver.findElement(By.tagName("form")).getText().contains("* Name is required"));
	}

	/*
	 * Teste 03: Email em branco | Usu�rio n�o preenche email e aparece mensagem de
	 * erro
	 */
	@Test
	public void emailEmBranco() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("name")).sendKeys("Luiz");
		driver.findElement(By.cssSelector("input[value='male']")).click();
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		assertTrue(driver.findElement(By.tagName("form")).getText().contains("* Email is required"));
	}

	/*
	 * Teste 04: Formato de email inv�lido | Usu�rio preenche email com formato
	 * inv�lido
	 */
	@Test
	public void emailInvalido() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("name")).sendKeys("Luiz");
		driver.findElement(By.name("email")).sendKeys("meu email");
		driver.findElement(By.cssSelector("input[value='male']")).click();
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		assertTrue(driver.findElement(By.tagName("form")).getText().contains("* Invalid email format"));
	}

	/*
	 * Teste 05: Website inv�lido | Usu�rio preenche website com formato inv�lido
	 */
	@Test
	public void websiteInvalido() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("name")).sendKeys("Luiz");
		driver.findElement(By.name("email")).sendKeys("luiz.contim@hotmail.com");
		driver.findElement(By.name("website")).sendKeys("meu site");
		driver.findElement(By.cssSelector("input[value='male']")).click();
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		assertTrue(driver.findElement(By.tagName("form")).getText().contains("Invalid URL"));
	}

	/*
	 * Teste 06: G�nero em branco | Usu�rio n�o seleciona o g�nero
	 */
	@Test
	public void generoEmBranco() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("name")).sendKeys("Luiz");
		driver.findElement(By.name("email")).sendKeys("luiz.contim@hotmail.com");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		assertTrue(driver.findElement(By.tagName("form")).getText().contains("* Gender is required"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
