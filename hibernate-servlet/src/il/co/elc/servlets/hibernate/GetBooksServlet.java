package il.co.elc.servlets.hibernate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.google.gson.Gson;

import il.co.electriccollege.library.Main;
import il.co.electriccollege.library.hibernate.DbSessionManager;
import il.co.electriccollege.library.hibernate.UserInputHandler;
import il.co.electriccollege.library.hibernate.entitities.Media;
import il.co.electriccollege.realestate.entity.Property;

/**
 * Servlet implementation class GetBooksServlet
 */
@WebServlet("/books")
public class GetBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();

		// construct a Properties instance with values from the web.xml configuration params
		ServletContext context = getServletContext();  
		Properties configProps = new Properties();
		configProps.put("hibernate.connection.url", context.getInitParameter("hibernate.connection.url"));
		configProps.put("hibernate.connection.username", context.getInitParameter("hibernate.connection.username"));
//		configProps.put("hibernate.connection.password", context.getInitParameter("hibernate.connection.password"));
		new UserInputHandler(configProps);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// use Media class to get list of books
		response.setContentType("application/json");
		List<Media> allMedia = UserInputHandler.getAllMedia();
		Gson booksGson = new Gson();
		response.getWriter().append(booksGson.toJson(allMedia));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		// get a list of properties
		List<Property> allProperties = il.co.electriccollege.realestate.Main.getAllProperties();
		Gson booksGson = new Gson();
		resp.getWriter().append(booksGson.toJson(allProperties));
	}

}
