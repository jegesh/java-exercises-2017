package carsales.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import carsales.dal.Car;
import carsales.dal.CarDal;
import carsales.dal.DbConnector;

/**
 * Servlet implementation class GetCarsServlet
 */
@WebServlet("/cars")
public class GetCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDal dal = new CarDal(DbConnector.DB_PRODUCTION);
		
		try {
			List<Car> cars = dal.getCars();
			Gson gson = new Gson();

			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			response.getWriter().append(gson.toJson(cars).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	

}
