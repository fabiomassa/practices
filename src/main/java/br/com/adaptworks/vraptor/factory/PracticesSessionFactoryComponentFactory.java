package br.com.adaptworks.vraptor.factory;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/**
 * @author jonasabreu
 * 
 */
@Component
@ApplicationScoped
final public class PracticesSessionFactoryComponentFactory implements ComponentFactory<PracticesSessionFactory> {

	private final PracticesSessionFactory factory = new PracticesSessionFactory();

	@Override
	public PracticesSessionFactory getInstance() {
		return factory;
	}
}
