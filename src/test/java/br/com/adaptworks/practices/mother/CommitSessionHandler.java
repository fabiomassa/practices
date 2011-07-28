package br.com.adaptworks.practices.mother;

import org.hibernate.Session;

import br.com.adaptworks.vraptor.factory.PracticesSessionFactory;

/**
 * @author jonasabreu
 * 
 */
final public class CommitSessionHandler implements SessionHandler {

	private Session session;
	private final PracticesSessionFactory factory;

	public CommitSessionHandler() {
		factory = new PracticesSessionFactory();
		session = factory.openSession();
	}

	@Override
	public void afterSessionUse() {
		session.getTransaction().commit();
	}

	@Override
	public void beforeSessionUse() {
		session.beginTransaction();
	}

	@Override
	public void dispose() {
		session.close();
		session = factory.openSession();
		session.beginTransaction();
		session.createSQLQuery("delete from Carro;").executeUpdate();
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	@Override
	public Session session() {
		return session;
	}

}
