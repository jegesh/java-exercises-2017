package com.borka;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * Servlet implementation class ShowRGB
 */
@WebServlet("/ShowRGB")
public class ShowRGB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRGB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		String requestColor = request.getParameter("color");
		
		if(requestColor == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("Empty color type");
		}
			
	try {
       
	 JSONObject jsonPurple = new JSONObject();
	 jsonPurple.put("color", "purple") ;
	 jsonPurple.put("red", "123") ;
	 jsonPurple.put("green", "54") ;
	 jsonPurple.put("Blue", "42") ;
	 JSONObject jsonYellow = new JSONObject();
	 jsonYellow.put("color", "yellow") ;
	 jsonYellow.put("red", 224) ;
	 jsonYellow.put("green", 255) ;
	 jsonYellow.put("Blue", 5) ;
	JSONObject jsonBrown = new JSONObject();
	jsonBrown.put("color", "brown") ;
	 jsonBrown.put("red", 43) ;
	 jsonBrown.put("green", 76) ;
	 jsonBrown.put("Blue", 155) ;
	JSONArray colorArray = new JSONArray();
	colorArray.put(jsonPurple);
	colorArray.put(jsonBrown);
	colorArray.put(jsonYellow);
  
	for (int i = 0; i < colorArray.length(); i++) {
		
		JSONObject json = colorArray.getJSONObject(i);
		
		if (json.get("color").equals(requestColor))
		{
			System.out.println("Bingo !!! RGB is " + colorArray.getJSONObject(i));
		}
	}
	
	
	//System.out.println(colorArray.toString());
	//	System.out.println(jsonPurple.toString());
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
