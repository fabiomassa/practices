package br.com.adaptworks.practices.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.adaptworks.practices.bd.Carro;
import br.com.adaptworks.practices.controller.CarroController;
import br.com.adaptworks.practices.dao.CarroDao;
import br.com.caelum.vraptor.Result;

public class CarroControllerTest {

	@Mock
	private Result result;

	@Mock
	private CarroDao carroDao;

	private CarroController mockedController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockedController = mock(CarroController.class);
	}

	@Test
	public void testaQueRetornaListaDeTodosCarros() {

		List<Carro> users = new ArrayList<Carro>();

		when(carroDao.list()).thenReturn(users);

		new CarroController(result, carroDao).usuarios();

		verify(result).include("carros", users);
	}

}
