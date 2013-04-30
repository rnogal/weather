package org.sonatype.weather;

import java.io.InputStream;

public class WeatherService {

	public String forecast(String zip) throws Exception {
		InputStream dataIn = new YahooRetriever().retrieve(zip);
		
		Weather weather = new YahooParser().parse(dataIn);
		
		return new YahooFormatter().format(weather); 
	}
}
