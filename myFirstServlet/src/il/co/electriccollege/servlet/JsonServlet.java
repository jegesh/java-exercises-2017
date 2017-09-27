package il.co.electriccollege.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import il.co.electriccollege.database.Property;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/json-servlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String KEY_DATA = "data";
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String data = request.getParameter("data");
		Property property = new Property();
        property.setAddress("5 HaShalom, Hadera");
        property.setFloor(2);
        property.setName("Electric College");
        property.setNumOfRooms(15);
        property.setYard(0);
		
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put(KEY_DATA, data);
		HashMap<String, Object> subMap = new HashMap<>();
		subMap.put("first_value", "one");
		subMap.put("second_val", "two");
		dataMap.put("submap", subMap);
		dataMap.put("property", property);
		
		Gson gson = new Gson();
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		response.getWriter().append("Unknown operation");
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
