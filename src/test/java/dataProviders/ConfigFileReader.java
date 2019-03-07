package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

		private Properties properties;
		
		//properties is subclass of Hashtable 
//		it stores values of key and value in string
//		we can specify default value for any key with no value
		
		private final String propertyFilePath = "configs//Configuration.properties";
		
		public ConfigFileReader() {
			
			BufferedReader reader;
			try {
				reader = new BufferedReader (new FileReader (propertyFilePath));
				properties = new Properties();
				
				try {
					properties.load(reader);
					reader.close();
				}
				
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			catch(FileNotFoundException e ) {
				
				e.printStackTrace();
				throw new RuntimeException ("Configuration.properties not found at " + propertyFilePath );
			}
		}
		
		public String getDriverPath () {
			String driverPath = properties.getProperty("driverPath");
			if(driverPath!=null) return driverPath;
			else throw new RuntimeException ("driver path not specified in Configuration.properties");
		}
		
		public long getImplicitlyWait() {
			String implicitlyWait = properties.getProperty("implicitlyWait");
			if(implicitlyWait!=null) return Long.parseLong(implicitlyWait);
			else throw new RuntimeException ("implicitlyWait not specified in configuration.properties");
		}
		
		public String getURL1() {
			String url1 = properties.getProperty("url1");
			if(url1!=null) return url1;
			else throw new RuntimeException ("url1 not specified in configuration.properties");
		}
		
		public String getURL2() {
			String url2 = properties.getProperty("url2");
			if(url2!=null) return url2;
			else throw new RuntimeException ("url2 not specified in configuration.properties");
		}
}
