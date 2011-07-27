package br.com.adaptworks.awsite.mother;

import org.hibernate.Session;

import br.com.adaptworks.vraptor.factory.AwsiteSessionFactory;

/**
 * @author jonasabreu
 * 
 */
final public class NoCommitSessionHandler implements SessionHandler {

	private final Session session;
	private final AwsiteSessionFactory factory;

	public NoCommitSessionHandler() {
		factory = new AwsiteSessionFactory();
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
