package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testes.DSL;

public class ComponentesPage {
	
	public DSL dsl;
	
	public ComponentesPage(WebDriver driver) {
		this.dsl = new DSL(driver);
	}
	
	public void setNome(String nome) {
		this.dsl.escrever("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		this.dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		this.dsl.clicar("elementosForm:sexo:0");
	}
	
	public void setComidaFavoritaCarne() {
		this.dsl.clicar("elementosForm:comidaFavorita:0");
	}	

	public void setComidaFavoritaFrango() {
		this.dsl.clicar("elementosForm:comidaFavorita:1");	
	}
	
	public void setComidaFavoritaPizza() {
		this.dsl.clicar("elementosForm:comidaFavorita:2");	
	}
	
	public void setEscolaridadeEspecializacao() {
		WebElement comboEscolaridade = this.dsl.encontrarElemento("elementosForm:escolaridade");  
		this.dsl.selecionar(comboEscolaridade, "Especializacao");		
	}
	
	public void setEsporteNatacao() {
		WebElement comboEsporte =  this.dsl.encontrarElemento("elementosForm:esportes");
		this.dsl.selecionar(comboEsporte, "Natacao");		
	}
	
	public void setEsporteFutebol() {
		WebElement comboEsporte =  this.dsl.encontrarElemento("elementosForm:esportes");
		this.dsl.selecionar(comboEsporte, "Futebol");		
	}
	
	public void setSugestao(String sugestao) {
		this.dsl.escrever("elementosForm:sugestoes", sugestao);		
	}
	
	public Boolean isComidaFavoritaCarne() {
		return this.dsl.isElementoSelecionado("elementosForm:comidaFavorita:0"); 	
	}	
	
	public Boolean isComidaFavoritaFrango() {
		return this.dsl.isElementoSelecionado("elementosForm:comidaFavorita:1"); 	
	}	
	
	public Boolean isComidaFavoritaPizza() {
		return this.dsl.isElementoSelecionado("elementosForm:comidaFavorita:2"); 	
	}
	
	public Boolean isComidaFavoritaVegetariano() {
		return this.dsl.isElementoSelecionado("elementosForm:comidaFavorita:3"); 	
	}			
	
	public String getNome() {
		return this.dsl.getValorDoElemento("elementosForm:nome");
	}
	
	public String getSobrenome() {
		return this.dsl.getValorDoElemento("elementosForm:sobrenome");
	}
	
	public String getEspecializacao() {
		WebElement comboEscolaridade = this.dsl.encontrarElemento("elementosForm:escolaridade"); 
		return this.dsl.pegarTextoSelecionadoDoCombo(comboEscolaridade);
	}		
	
	public String getSugestao() {
		return this.dsl.getValorDoElemento("elementosForm:sugestoes");
	}	
	
	public Boolean isSexoMasculino() {
		return this.dsl.isElementoSelecionado("elementosForm:sexo:0");
	}	
	
	public Boolean isSexoFeminino() {
		return this.dsl.isElementoSelecionado("elementosForm:sexo:1");
	}	
}
