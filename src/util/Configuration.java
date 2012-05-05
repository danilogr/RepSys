package util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class Configuration {

	private static String PROP_FILE_NAME = "configuration.properties";

	private static Configuration instance = null;

	private Properties properties;

	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

	private Configuration() {
		properties = new Properties();
		try {
			URL url = Configuration.class.getClassLoader().getResource(
					PROP_FILE_NAME);
			File file = new File(url.toURI());
			// File file = new File(PROP_FILE_NAME);
			FileInputStream stream = new FileInputStream(file);
			properties.load(stream);
		} catch (Exception e) {
			System.out.println("Erro no acesso ao arquivo de configura��o");
		}
	}

	public Properties getProperties() {
		return properties;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
