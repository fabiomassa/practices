package br.com.adaptworks.practices.cfg;

import org.apache.log4j.Logger;

/**
 * @author jonasabreu
 * 
 */
final public class PracticesConfiguration {

	private final static Environment environment;

	private final static Logger log = Logger
			.getLogger(PracticesConfiguration.class);

	static {
		environment = Environment.fromValue(System.getProperty("environment"));
		log.info("Detected environment as: " + environment);
	}

	public String getHibernateCfgFileName() {
		return environment.getHibernateCfgFileName();
	}

}
