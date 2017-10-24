package carsales.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CarDalTest {
	
	@Before
	public void clearDb() throws SQLException {
		Connection conn = new DbConnector(DbConnector.DB_TEST).getDbConnection();
		conn.createStatement().execute("DELETE FROM car");
		conn.close();
	}
	
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
		
		assert cars.size() == 1;
		
		assert cars.get(0).getPhone().equals("phone");
	}

}
