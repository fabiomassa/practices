package br.com.adaptworks.practices.dao.integration;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.adaptworks.practices.bd.Carro;
import br.com.adaptworks.practices.dao.CarroDao;
import br.com.adaptworks.practices.mother.Mother;
import br.com.adaptworks.practices.mother.NoCommitSessionHandler;

public class CarroDaoIntegrationTest {

	private Mother mother;
	private CarroDao dao;

	@Before
	public void setup() {
		mother = new Mother(new NoCommitSessionHandler());
		dao = new CarroDao(mother.session());
	}

	@After
	public void tearDown() {
		mother.dispose();
	}

	@Test
	public void testaQueRetornaTodosOsCarros() {
		mother.novoCarro().comNome("gol").comMarca("volkswagen").build();
		mother.novoCarro().comNome("palio").comMarca("fiat").build();
		mother.novoCarro().comNome("fiesta").comMarca("ford").build();

		List<Carro> carros = dao.list();

		Assert.assertEquals(3, carros.size());
	}

	@Test
	public void testaQueRetornaApenasCarrosVerdes() {
		mother.novoCarro().comNome("gol").comCor("vermelho").build();
		mother.novoCarro().comNome("gol").comCor("azul").build();
		mother.novoCarro().comNome("gol").comCor("verde").build();

		List<Carro> carros = dao.listByColor("verde");

		Assert.assertEquals(1, carros.size());
	}

	@Test
	public void testaQueRetornaApenasCarrosDaFiat() {
		mother.novoCarro().comNome("gol").comMarca("volkswagen").build();
		mother.novoCarro().comNome("saveiro").comMarca("volkswagen").build();
		mother.novoCarro().comNome("palio").comMarca("fiat").build();
		mother.novoCarro().comNome("uno").comMarca("fiat").build();
		mother.novoCarro().comNome("fiesta").comMarca("ford").build();
		mother.novoCarro().comNome("focus").comMarca("ford").build();

		List<Carro> carros = dao.listByBrand("fiat");

		Assert.assertEquals(2, carros.size());
	}

}
