package br.com.adaptworks.practices.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Session;

import br.com.adaptworks.practices.bd.Carro;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class CarroDao {

	private final Session session;

	public CarroDao(final Session session) {
		this.session = session;
	}

	public Carro get(final Carro user) {
		return (Carro) session.get(Carro.class, user.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Carro> list() {
		return session.createCriteria(Carro.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Carro> listByColor(final String cor) {
		return session.createCriteria(Carro.class).add(eq("cor", cor)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Carro> listByBrand(final String marca) {
		return session.createCriteria(Carro.class).add(eq("marca", marca))
				.list();
	}
}
