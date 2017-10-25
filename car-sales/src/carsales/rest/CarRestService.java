package carsales.rest;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import carsales.dal.Car;
import carsales.dal.CarDal;
import carsales.dal.DbConnector;

@Path("car")
public class CarRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCars() {
		CarDal dal = new CarDal(DbConnector.DB_PRODUCTION);
		
		try {
			List<Car> cars = dal.getCars();
			Gson gson = new Gson();

			return gson.toJson(cars).toString();
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} 
	}
	
	@POST
	public String addCar(
				@QueryParam("description") String desc,
				@QueryParam("phone") String phone
			) {
		Car car = new Car();
		car.setDescription(desc);
		car.setPhone(phone);
		
		try {
			new CarDal(DbConnector.DB_PRODUCTION).addCar(car);
			return "Successful";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@GET
	@Path("{id}")
	public String getCar(
				@PathParam("id") long id
			) {
		
		return "car id: " + id;
		
	}
}




