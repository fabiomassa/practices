package br.com.adaptworks.practices.builder;

import br.com.adaptworks.practices.bd.Carro;
import br.com.adaptworks.practices.mother.SessionHandler;

public class CarroBuilder {

	private final SessionHandler handler;
	private final Carro carro;

	public CarroBuilder(SessionHandler handler) {
		this.handler = handler;
		carro = new Carro();
	}

	public CarroBuilder comNome(String nome) {
		carro.setNome(nome);
		return this;
	}

	public CarroBuilder comMarca(String marca) {
		carro.setMarca(marca);
		return this;
	}

	public CarroBuilder comCor(String cor) {
		carro.setCor(cor);
		return this;
	}

	public Carro build() {
		handler.beforeSessionUse();
		handler.session().persist(carro);
		Carro retrieve = (Carro) handler.session().get(Carro.class,
				carro.getId());
		handler.afterSessionUse();
		return retrieve;
	}

}
