package br.com.adaptworks.practices.cfg;

/**
 * @author jonasabreu
 * 
 */
public enum Environment {
	TEST, DEVELOPMENT, PRODUCTION;

	public static Environment fromValue(final String property) {
		for (Environment env : values()) {
			if (env.toString().equalsIgnoreCase(property)) {
				return env;
			}
		}
		return DEVELOPMENT;
	}

	public String getHibernateCfgFileName() {
		return getFileName("hibernate", "cfg.xml");
	}

	public String getPathToImagesFolder() {
		return getFileName("pathImagens", "properties");
	}

	private String getFileName(final String prefix, final String sufix) {
		return "/" + prefix + "-" + toString().toLowerCase() + "." + sufix;
	}

}
