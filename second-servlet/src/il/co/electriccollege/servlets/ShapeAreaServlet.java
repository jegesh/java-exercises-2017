package il.co.electriccollege.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShapeAreaServlet
 */
@WebServlet({"/shape-area", "/shapes"})
public class ShapeAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		String shapeName = null;
		Float height = 0F;
		Float width = 0F;
		
		try {
			shapeName = request.getParameter("shape").toLowerCase();
			height = Float.valueOf(request.getParameter("height"));
			width = Float.valueOf(request.getParameter("width"));
		}catch(NullPointerException ex) {
			// parameter is missing
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("You must send all the parameters");
			return;
		}catch(NumberFormatException ex) {
			// height or width is not a number
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("Height and width must be valid numbers");
			return;
		}
		
		if(height <= 0 || width <= 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("width and height must be greater than zero");
			return;
		}
		
		Float result = 0F;
		switch(shapeName) {
			case "square":
				result = height*height;
				break;
			case "rectangle":
				result = height*width;
				break;
			case "triangle":
				result = height*width/2F;
				break;
			default:
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().append("Shape name must be square, rectangle, or triangle");
				return;
		}
		
		response.getWriter().append(String.valueOf(result));
		
	}

}
