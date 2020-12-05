package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ComponentesTest {

	private WebDriver driver;
		
	public WebDriver getDriver() {
		return driver;
	}	
	
	@Before
	public void setUp() {
		
		String pathDriver = System.getProperty("user.dir") + "/src/main/resources/geckodriver";
		String urlFile = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
		
		System.setProperty("webdriver.gecko.driver", pathDriver);
		
		this.driver = new FirefoxDriver();
		this.driver.get(urlFile);
		
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys("John");
		getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Travolta");
		
		getDriver().findElement(By.id("elementosForm:sexo:0")).click();
		
		getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
		getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).click();
		getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		WebElement comboEscolaridade = getDriver().findElement(By.id("elementosForm:escolaridade"));
		
		Select selectEscolaridade = new Select(comboEscolaridade);
		selectEscolaridade.selectByVisibleText("Especializacao");
		
		WebElement comboEsporte = getDriver().findElement(By.id("elementosForm:esportes"));
		
		Select selectEsporte = new Select(comboEsporte);
		selectEsporte.selectByVisibleText("Natacao");
		selectEsporte.selectByVisibleText("Futebol");
		
		getDriver().findElement(By.id("elementosForm:sugestoes")).sendKeys("Nenhuma sugestão!");
	}

	@Test
	public void deveNomeSerJohnESobrenomeSerTravolta() {
		String nome = getDriver().findElement(By.id("elementosForm:nome")).getAttribute("value");
		String sobrenome = getDriver().findElement(By.id("elementosForm:sobrenome")).getAttribute("value");
		
		assertEquals("John", nome);
		assertEquals("Travolta", sobrenome);
	}
	
	@Test
	public void deveSexoSerMasculino() {
		Boolean sexoMasculino = getDriver().findElement(By.id("elementosForm:sexo:0")).isSelected();
		Boolean sexoFeminino = getDriver().findElement(By.id("elementosForm:sexo:1")).isSelected();
		
		assertTrue(sexoMasculino);
		assertFalse(sexoFeminino);
	}	
	
	@Test
	public void deveComidaFavoritaSerCarneFrangoEPizza() {
		Boolean carne = getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).isSelected();
		Boolean frango = getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).isSelected();
		Boolean pizza = getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).isSelected();
		Boolean vegetariano = getDriver().findElement(By.id("elementosForm:comidaFavorita:3")).isSelected();
		
		assertTrue(carne);
		assertTrue(frango);
		assertTrue(pizza);		
		assertFalse(vegetariano);
	}	
	
	@Test
	public void deveEscolaridadeSerEspecializacao() {
		WebElement comboEscolaridade = getDriver().findElement(By.id("elementosForm:escolaridade"));
		
		Select selectEscolaridade = new Select(comboEscolaridade);
		String escolaridadeSelecionada = selectEscolaridade.getFirstSelectedOption().getText();
		
		assertEquals("Especializacao", escolaridadeSelecionada);
	}
	
	@Test
	public void deveSugestaoSerNenhumaSugestao() {
		String sugestao = getDriver().findElement(By.id("elementosForm:sugestoes")).getAttribute("value");
				
		assertEquals("Nenhuma sugestão!", sugestao);
	}	
	
	@After
	public void quit() {
		getDriver().quit();
	}
}
