package electric.college.test.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Servlet implementation class ReversalServlet
 */
@WebServlet("/reverse")
public class ReversalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String originalWord = request.getParameter("word");
		String reversedWord = new StringBuilder(originalWord).reverse().toString();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("original", originalWord);
			jsonObject.put("reversed", reversedWord);
			response.setContentType("application/json");
			response.getWriter().append(jsonObject.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().append(e.getMessage());
		}
		
	}

}
