package br.com.adaptworks.vraptor.factory;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class HibernateSessionComponentFactory implements ComponentFactory<Session> {

	private final PracticesSessionFactory factory;
	private Session session;

	public HibernateSessionComponentFactory(final PracticesSessionFactory factory) {
		this.factory = factory;
	}

	public Session getInstance() {
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}

}
