package org.sonatype.weather;

import java.io.*;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.*;


public class YahooFormatter {

	public String format(Weather weather) throws Exception {

		Reader reader = new InputStreamReader(this.getClass().getResourceAsStream("output.vm"));
		VelocityContext ctx = new VelocityContext();
		ctx.put("weather", weather);
		StringWriter writer = new StringWriter();
		Velocity.evaluate(ctx, writer, "", reader);
		return writer.toString();
	}

}
