package br.com.adaptworks.awsite.mother;

import org.hibernate.Session;

/**
 * @author jonasabreu
 * 
 */
public interface SessionHandler {

	public Session session();

	public void beforeSessionUse();

	public void afterSessionUse();

	public void dispose();

}
