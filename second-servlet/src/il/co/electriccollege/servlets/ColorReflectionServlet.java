package il.co.electriccollege.servlets;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class ColorReflectionServlet
 */
@WebServlet("/color-reflection")
public class ColorReflectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		// validation of parameter 
		String colorName = request.getParameter("color");
		if(colorName == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("Param 'color' missing");
			return;
		}
		
		colorName.toLowerCase().trim();
		Color c = null;
		Field colorInt = null;
		try {
			colorInt = Color.class.getField(colorName);
			 c = (Color)colorInt.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("red", c.getRed());
		json.addProperty("green", c.getGreen());
		json.addProperty("blue", c.getBlue());
		
		
		response.getWriter().append(json.toString());
        
	}

}
