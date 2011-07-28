package br.com.adaptworks.practices.controller;

import br.com.adaptworks.practices.dao.CarroDao;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CarroController {

	private final Result result;
	private final CarroDao carroDao;

	public CarroController(final Result result, final CarroDao carroDao) {
		this.result = result;
		this.carroDao = carroDao;
	}

	@Get
	@Path("/admin/carros")
	public void carros() {
		result.include("carros", carroDao.list());
	}

	@Get
	@Path("/admin/carros/{marca}")
	public void carros(final String marca) {
		result.include("carros", carroDao.listByBrand(marca));
	}

}
