package il.co.electriccollege.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.ContentType;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/hello-world")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
//		Map<String, String[]> parameters = request.getParameterMap();
		String name = request.getParameter("name");
		String acceptContentType = request.getHeader("Accept").toString();
		Cookie[] cookies = request.getCookies();
		
		response.getWriter().append("Hello " + name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Hello Post");
		
	}

}
