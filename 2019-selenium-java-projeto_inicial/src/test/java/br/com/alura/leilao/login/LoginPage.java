package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	private static final String URL_LOGIN = "http://localhost:8080/login?erro";
	private static final String URL_LANCES = "http://localhost:8080/leiloes/2";

	private WebDriver browser;

	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\OneDrive\\Área de Trabalho\\exe\\selenium\\2019-selenium-java-projeto_inicial\\driver/chromedriver.exe");
		this.browser = new ChromeDriver();
		this.browser.navigate().to(URL_LOGIN);
	}

	public void preencherFormularioDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public void efetuarLogin() {
		browser.findElement(By.id("login-form")).submit();
	}

	public boolean getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText() != null;
		} catch (NoSuchElementException e) {
			return null != null;
		}
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().contains(URL_LOGIN);
	}

	public boolean isMensagemDeLoginInvalidoVisivel() {
		return browser.getPageSource().contains("Usuário e senha inválidos");
	}

	public void fechar() {
		this.browser.quit();
	}
	
	public void acessolances() {
		browser.navigate().to(URL_LANCES);
		
	}
	public boolean conntemTexto(String texto) {
		
		return browser.getPageSource().contains(texto);
	}
	public boolean isUrlDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

}