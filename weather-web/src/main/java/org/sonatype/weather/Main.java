package org.sonatype.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main{
	
	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
		String zipCode = "60202";
		try {
			zipCode = args[0];
		} catch (Exception e) {
			// TODO: handle exception
		}
		new Main(zipCode).start();
		
	} 
	
	public Main(String zipCode) {
		this.zipCode = zipCode;
	}
	
	private String zipCode;
	
	public void start() throws Exception {
		
		System.out.println(new WeatherService().forecast(zipCode)); 
	}
	
	

}
