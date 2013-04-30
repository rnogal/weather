package org.sonatype.web;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.sonatype.weather.*;

public class ForecastServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zipCode = request.getParameter("zip");
		WeatherService service = new WeatherService();
		PrintWriter out = response.getWriter();
		try {
			out.print(service.forecast(zipCode));
		} catch (Exception e) {
			out.print("Error retrieving forecast");
		}
		out.flush();
		out.close();
		
	}

}
