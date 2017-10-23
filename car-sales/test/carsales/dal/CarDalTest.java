package carsales.dal;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class CarDalTest {
	
	@Test
	public void testGetCars() throws SQLException {
		CarDal dal = new CarDal(DbConnector.DB_TEST);
		List<Car> cars = dal.getCars();
		
		assert cars.size() == 0;
		
		Car c = new Car();
		c.setDescription("desc");
		c.setPhone("phone");
		
		dal.addCar(c);
		cars = dal.getCars();
		
		assert cars.size() == 2;
		
		assert cars.get(0).getPhone().equals("phone");
	}

}
