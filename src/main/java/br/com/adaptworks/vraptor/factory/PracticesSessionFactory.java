package br.com.adaptworks.vraptor.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.adaptworks.practices.cfg.PracticesConfiguration;

public class PracticesSessionFactory {

	private final SessionFactory sessionFactory;

	public PracticesSessionFactory() {
		AnnotationConfiguration configuration = new AnnotationConfiguration().configure(new PracticesConfiguration()
				.getHibernateCfgFileName());

		sessionFactory = configuration.buildSessionFactory();
	}

	public Session openSession() {
		return sessionFactory.openSession();
	}

	public void close() {
		sessionFactory.close();
	}

}
