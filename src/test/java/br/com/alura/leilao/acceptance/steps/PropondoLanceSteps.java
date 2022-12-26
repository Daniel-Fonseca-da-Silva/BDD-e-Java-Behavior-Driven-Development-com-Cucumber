package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	private Lance lance10;
	private Lance lance100;

	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("Roberto");
		lance = new Lance(usuario, BigDecimal.TEN);
		leilao = new Leilao("Carros 10");
	}

	@Quando("propoe o lance ao leilao")
	public void quando_propoe_o_lance() {
		leilao.propoe(lance);
	}
	
	@Entao("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	@Dado("varios lances validos")
	public void varios_lances_validos() {
		
		Usuario usuario0 = new Usuario("Fulano");
		lance10 = new Lance(usuario0, BigDecimal.ONE);
		
		Usuario usuario1 = new Usuario("Bertrano");
		lance100 = new Lance(usuario1, new BigDecimal("100.00"));
		
		leilao = new Leilao("Carros 10");
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		leilao.propoe(lance10);
		leilao.propoe(lance100);
	}
	
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertEquals(2, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.ONE, leilao.getLances().get(0).getValor());
		Assert.assertEquals(new BigDecimal("100.00"), leilao.getLances().get(1).getValor());
	}

}
