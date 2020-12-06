package testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void escrever(String id, String texto) {
		getDriver().findElement(By.id(id)).sendKeys(texto);
	}
	
	public void clicar(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public WebElement encontrarElemento(String id) {
		return getDriver().findElement(By.id(id));
	}
	
	public void selecionar(WebElement combo, String texto) {
		Select select = new Select(combo);
		select.selectByVisibleText(texto);		
	}
	
	public String getValorDoElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	public Boolean isElementoSelecionado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public String pegarTextoSelecionadoDoCombo(WebElement combo) {
		Select selectEscolaridade = new Select(combo);
		return selectEscolaridade.getFirstSelectedOption().getText();		
	}	
	
	public void fechar() {
		getDriver().quit();
	}
}
