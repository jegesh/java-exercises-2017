package il.co.electriccollege.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.ContentType;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		
		String operation = request.getParameter("operation");
		String firstOperand = request.getParameter("first");
		String secondOperand = request.getParameter("second");
		
		// check that all parameters are present
		if(operation == null || firstOperand == null || secondOperand == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("one of the parameters is missing");
			return;
			
		}
		
		// validate operation
		String operations = "+-*/";
		if(operation.length() != 1 || !operations.contains(operation)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("operation parameter may be only one of the following: + - * /");
			return;
		}
		
		try {
			// validate operands
			float firstFloat = Float.parseFloat(firstOperand);
			float secondFloat = Float.parseFloat(secondOperand);
			
			// everything is valid, now I can do the calculation
			
		}catch(NumberFormatException exc) {
			exc.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("parameters first and second must be valid numbers");
			return;
		}
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setStatus(400);
//		String name = req.getParameter("name");
//		try {
//			name.length();
//		}catch(Exception e) {
//			
//		}
		doPost(req, resp);
	}

}
