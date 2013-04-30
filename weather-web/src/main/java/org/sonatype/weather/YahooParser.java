package org.sonatype.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {

	public static Logger log = Logger.getLogger(YahooParser.class);

	public Weather parse(InputStream dataIn) throws Exception {
		Weather weather = new Weather();
		log.info("parsing data");
		
		SAXReader reader = createSAXReader();
		Document doc = reader.read(dataIn);
		
		weather.setCity(doc.valueOf("/rss/channel/y:location/@city"));
		weather.setRegion(doc.valueOf("/rss/channel/y:location/@region"));
		weather.setCountry(doc.valueOf("/rss/channel/y:location/@country"));
		weather.setCondition(doc.valueOf("/rss/channel/item/y:condition/@text"));
		weather.setTemp(doc.valueOf("/rss/channel/item/y:condition/@temp"));
		weather.setChill(doc.valueOf("/rss/channel/y:wind/@chill"));
		weather.setHumidity(doc.valueOf("/rss/channel/y:atmosphere/@humidity"));
		return weather;
	}

	private SAXReader createSAXReader() {
		Map<String, String> uris = new HashMap<String, String>();
		uris.put("y", "http://xml.weather.yahoo.com/ns/rss/1.0");
		
		DocumentFactory factory = new DocumentFactory();
		factory.setXPathNamespaceURIs(uris);
		
		SAXReader reader = new SAXReader(factory);
		return reader;
	}

}
