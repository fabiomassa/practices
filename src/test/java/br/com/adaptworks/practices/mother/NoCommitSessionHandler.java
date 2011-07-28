package br.com.adaptworks.practices.mother;

import org.hibernate.Session;

import br.com.adaptworks.vraptor.factory.PracticesSessionFactory;

/**
 * @author jonasabreu
 * 
 */
final public class NoCommitSessionHandler implements SessionHandler {

	private final Session session;
	private final PracticesSessionFactory factory;

	public NoCommitSessionHandler() {
		factory = new PracticesSessionFactory();
		session = factory.openSession();
		session.beginTransaction();
	}

	@Override
	public void afterSessionUse() {
	}

	@Override
	public void beforeSessionUse() {
	}

	@Override
	public void dispose() {
		session().getTransaction().rollback();
		session().close();
		factory.close();
	}

	@Override
	public Session session() {
		return session;
	}

}
