package carsales.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsales.dal.Car;
import carsales.dal.CarDal;
import carsales.dal.DbConnector;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/cars/add")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desc = request.getParameter("description");
		String phone = request.getParameter("phone");
		
		if(desc == null || phone == null) {
			// missing parameter
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		Car car = new Car();
		car.setDescription(desc);
		car.setPhone(phone);
		
		try {
			boolean inserted = new CarDal(DbConnector.DB_PRODUCTION).addCar(car);
			response.setContentType("text/plain");
			response.getWriter().write("Successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
