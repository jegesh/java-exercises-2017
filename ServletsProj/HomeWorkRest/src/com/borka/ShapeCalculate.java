package com.borka;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShapeCalculate
 */
@WebServlet("/ShapeCalculate")
public class ShapeCalculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShapeCalculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		String shape =request.getParameter("shape");
		String width =request.getParameter("width");
		String height=request.getParameter("height");
		double areaResult=0.0;
		if (shape==null||height ==null||width==null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("one of the parameters is missing");
	          	}
		
		try {
			
		int widthNum = Integer.parseInt(width);
		int heightNum = Integer.parseInt(height);
		
//		float widthNum = Float.parseFloat(width);
//		float heightNum = Float.parseFloat(height);
			
		
		switch (shape) {
		   case "square":   
			   if(widthNum != heightNum)
			   {
				   response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				   response.getWriter().append("width is not equal height. Not Square !!!"); 
			   } 
			   areaResult =widthNum*widthNum;
			break;
				
		case "triangle":
			 areaResult =(widthNum*heightNum)/2;
			break;
			
		case "rectangle":
			 areaResult =widthNum*heightNum;
			break;
			
		default:
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("Type of shape is wrong");
			break;
		}
		
		 response.getWriter().append("Area of: "+ shape +" is " + areaResult); 
	
	} catch (NumberFormatException e)
	{
		e.printStackTrace();
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		response.getWriter().append("parameters first and second must be valid numbers");
		//return;
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
