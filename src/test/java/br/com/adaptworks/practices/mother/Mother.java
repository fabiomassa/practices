package br.com.adaptworks.practices.mother;

import org.hibernate.Session;

import br.com.adaptworks.practices.builder.CarroBuilder;

public class Mother {

	private final SessionHandler handler;

	public Mother(final SessionHandler handler) {
		this.handler = handler;
	}

	public void dispose() {
		handler.dispose();
	}

	public Session session() {
		return handler.session();
	}

	public CarroBuilder novoCarro() {
		return new CarroBuilder(handler);
	}

}
