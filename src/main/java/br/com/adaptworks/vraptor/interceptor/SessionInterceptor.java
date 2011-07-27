package br.com.adaptworks.vraptor.interceptor;

import org.hibernate.Session;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@RequestScoped
public class SessionInterceptor implements Interceptor {

	private final Session session;

	public SessionInterceptor(final Session session) {
		this.session = session;
	}

	public boolean accepts(final ResourceMethod arg0) {
		return true;
	}

	public void intercept(final InterceptorStack stack, final ResourceMethod resource, final Object object)
			throws InterceptionException {

		try {
			stack.next(resource, object);
		} finally {
			session.close();
		}

	}

}
