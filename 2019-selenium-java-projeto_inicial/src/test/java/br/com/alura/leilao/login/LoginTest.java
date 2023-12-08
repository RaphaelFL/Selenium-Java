package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class LoginTest {
	
	private LoginPage paginaDeLogin;	

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuarLogin();

		boolean nomeUsuarioLogado = paginaDeLogin.getNomeUsuarioLogado();
		Assert.assertFalse(nomeUsuarioLogado);
		Assert.assertTrue(paginaDeLogin.isPaginaAtual());
	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.preencherFormularioDeLogin("invalido", "1233");
		paginaDeLogin.efetuarLogin();

		Assert.assertFalse(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.isPaginaAtual());
		Assert.assertTrue(paginaDeLogin.isMensagemDeLoginInvalidoVisivel());
	}

	@Test
	void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
		paginaDeLogin.acessolances();
		

		Assert.assertFalse(paginaDeLogin.isUrlDeLogin());
		Assert.assertFalse(paginaDeLogin.conntemTexto("Dados do Leilão"));
	}

} 
