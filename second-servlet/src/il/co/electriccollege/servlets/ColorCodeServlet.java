package il.co.electriccollege.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ColorCodeServlet
 */
@WebServlet("/color-code")
public class ColorCodeServlet extends HttpServlet {
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
		
		HashMap<String, String[]> colorMap = getColorMap();
		int red, green, blue;
		String[] rgb = colorMap.get(colorName);
		
		// validation of color name
		if(rgb == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("Unknown color");
			return;
		}
		
		red = Integer.valueOf(rgb[0], 16);
		green = Integer.valueOf(rgb[1], 16);
		blue = Integer.valueOf(rgb[2], 16);
		
		JsonObject json = new JsonObject();
		json.addProperty("red", red);
		json.addProperty("green", green);
		json.addProperty("blue", blue);
		
		response.getWriter().append(json.toString());
	}
	
	private static HashMap<String, String[]> getColorMap(){
		HashMap<String, String[]> colorMap = new HashMap<>();
		colorMap.put("white", new String[] {"ff","ff","ff"});
		colorMap.put("black", new String[] {"00","00","00"});
		colorMap.put("grey", new String[] {"80","80","80"});
		colorMap.put("teal", new String[] {"00","80","80"});
		return colorMap;
	}

}
