package com.pvv.app.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.pvv.app.util.ResourceUtil;






public class DataSourceProperties {

	private static final Properties ENVIRONMENT_PROPERTIES = ResourceUtil.loadProperties("environment.properties");

	private static final String DATA_SOURCE_PROPERTIES_LOCATION = ENVIRONMENT_PROPERTIES
			.getProperty("datasourcePropertiesLocation");

	private static final Properties DATA_SOURCE_PROPERTIES = getDataSourceProperties();

	public static final String CRM_URL = DATA_SOURCE_PROPERTIES.getProperty("crmURL");
	public static final String CRM_USER = DATA_SOURCE_PROPERTIES.getProperty("crmUser");
	public static final String CRM_PASSWORD = DATA_SOURCE_PROPERTIES.getProperty("crmPassword");
	public static final String CRM_DRIVER = DATA_SOURCE_PROPERTIES.getProperty("driverClassName");
	

	public static Properties getDataSourceProperties() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(DATA_SOURCE_PROPERTIES_LOCATION));
		} catch (IOException e) {
			return ResourceUtil.loadProperties(DATA_SOURCE_PROPERTIES_LOCATION);
		}
		return prop;
	}

	DataSourceProperties() {
		
	}
}
