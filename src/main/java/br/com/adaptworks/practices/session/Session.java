package br.com.adaptworks.practices.session;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Session {

	private final HttpSession session;

	public Session(final HttpSession session) {
		this.session = session;
	}

	public void add(final String key, final Object value) {
		session.setAttribute(key, value);
	}

	public Object get(final String key) {
		return session.getAttribute(key);
	}

	public void invalidate() {
		session.invalidate();
	}
}
