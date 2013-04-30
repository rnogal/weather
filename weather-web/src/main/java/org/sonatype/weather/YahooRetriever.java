package org.sonatype.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {
	
	public static Logger log = Logger.getLogger(YahooRetriever.class);
	
	public InputStream retrieve(String zip) throws Exception {
		log.info("Retrieving info from Yahoo!");
		String url = "http://weather.yahooapis.com/forecastrss?p=" + zip;
		URLConnection connection = new URL(url).openConnection();
		return connection.getInputStream();
		
	}
	

}
