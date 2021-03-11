package com.pvv.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 * @author victor camacho
 *
 */
public class ResourceUtil {
	
	public static Properties loadProperties(String dir){
		Properties prop = new Properties();
		InputStream is = null;
		try {
			is = ResourceUtil.class.getClassLoader().getResourceAsStream(dir);
			prop.load(is);
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		
		return prop;
	}

}
