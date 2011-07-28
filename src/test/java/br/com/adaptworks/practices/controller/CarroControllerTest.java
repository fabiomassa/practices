package br.com.adaptworks.practices.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.adaptworks.practices.bd.Carro;
import br.com.adaptworks.practices.dao.CarroDao;
import br.com.caelum.vraptor.Result;

public class CarroControllerTest {

	@Mock
	private Result result;

	@Mock
	private CarroDao carroDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testaQueRetornaListaDeTodosCarros() {

		List<Carro> carros = new ArrayList<Carro>();

		when(carroDao.list()).thenReturn(carros);

		new CarroController(result, carroDao).carros();

		verify(result).include("carros", carros);
	}

	@Test
	public void testaQueRetornaListaPelaMarca() {

		List<Carro> carros = new ArrayList<Carro>();

		when(carroDao.list()).thenReturn(carros);

		new CarroController(result, carroDao).carros("fiat");

		verify(result).include("carros", carros);
	}

}
