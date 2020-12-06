package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.ComponentesPage;

public class ComponentesTest {
	
	private WebDriver driver;
	private ComponentesPage page;

	@Before
	public void setUp() {
		
		String pathDriver = System.getProperty("user.dir") + "/src/main/resources/geckodriver";
		String urlFile = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
		
		System.setProperty("webdriver.gecko.driver", pathDriver);
		
		this.driver = new FirefoxDriver();
		this.driver.get(urlFile);
		this.page = new ComponentesPage(this.driver);
		
		this.page.setNome("John");
		this.page.setSobrenome("Travolta");
		this.page.setSexoMasculino();
		this.page.setComidaFavoritaCarne();
		this.page.setComidaFavoritaFrango();
		this.page.setComidaFavoritaPizza();
		this.page.setEscolaridadeEspecializacao();
		this.page.setEsporteNatacao();
		this.page.setEsporteFutebol();
		this.page.setSugestao("Nenhuma sugestão!");
	}

	@Test
	public void deveNomeSerJohnESobrenomeSerTravolta() {
		String nome = this.page.getNome();
		String sobrenome = this.page.getSobrenome();
		
		assertEquals("John", nome);
		assertEquals("Travolta", sobrenome);
	}
	
	@Test
	public void deveSexoSerMasculino() {
		Boolean sexoMasculino = this.page.isSexoMasculino();
		Boolean sexoFeminino = this.page.isSexoFeminino();
		
		assertTrue(sexoMasculino);
		assertFalse(sexoFeminino);
	}	
	
	@Test
	public void deveComidaFavoritaSerCarneFrangoEPizza() {
		Boolean carne = this.page.isComidaFavoritaCarne();
		Boolean frango = this.page.isComidaFavoritaFrango();
		Boolean pizza = this.page.isComidaFavoritaPizza();
		Boolean vegetariano = this.page.isComidaFavoritaVegetariano();
		
		assertTrue(carne);
		assertTrue(frango);
		assertTrue(pizza);		
		assertFalse(vegetariano);
	}	
	
	@Test
	public void deveEscolaridadeSerEspecializacao() {
		String escolaridadeSelecionada = this.page.getEspecializacao();
		
		assertEquals("Especializacao", escolaridadeSelecionada);
	}
	
	@Test
	public void deveSugestaoSerNenhumaSugestao() {
		String sugestao = this.page.getSugestao();
				
		assertEquals("Nenhuma sugestão!", sugestao);
	}	
	
	@After
	public void quit() {
		this.driver.quit();
	}
}
