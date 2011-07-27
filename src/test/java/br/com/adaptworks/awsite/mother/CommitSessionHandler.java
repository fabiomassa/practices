package br.com.adaptworks.awsite.mother;

import org.hibernate.Session;

import br.com.adaptworks.vraptor.factory.AwsiteSessionFactory;

/**
 * @author jonasabreu
 * 
 */
final public class CommitSessionHandler implements SessionHandler {

	private Session session;
	private final AwsiteSessionFactory factory;

	public CommitSessionHandler() {
		factory = new AwsiteSessionFactory();
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
		session.createSQLQuery("delete from Turma;").executeUpdate();
		session.createSQLQuery("delete from Endereco;").executeUpdate();
		session.createSQLQuery("delete from Usuario;").executeUpdate();
		session.createSQLQuery("delete from Instrutor;").executeUpdate();
		session.createSQLQuery("delete from Treinamento where pai is not null;").executeUpdate();
		session.createSQLQuery("delete from Treinamento;").executeUpdate();
		session.createSQLQuery("delete from Evento;").executeUpdate();
		session.createSQLQuery("delete from Opcao;").executeUpdate();
		session.createSQLQuery("delete from Questao;").executeUpdate();
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	@Override
	public Session session() {
		return session;
	}

}
