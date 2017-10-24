package carsales.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDal {
	private String dbName;
	
	public CarDal(String dbName) {
		this.dbName = dbName;
	}

	public List<Car> getCars() throws SQLException {
		String query = "SELECT * FROM car";
		
		// connect to database
		Connection conn = null;
		
		try {
			conn = new DbConnector(dbName).getDbConnection();
			
			// statement allows execution of queries
			Statement dbStatement = conn.createStatement();
			
			// result set contains the data from the database
			ResultSet results = dbStatement.executeQuery(query);
			
			List<Car> cars = new ArrayList<>();
			
			// iterate over the result set and extract the car objects
			while(results.next()) {
				Car car = buildFromResultSet(results);
				cars.add(car);
			}
			
			return cars;
			
		}finally {
			if(conn != null)
				conn.close();
		}
		
		
	}
	
	/**
	 * this method builds a Car object by parsing the raw data from the database
	 * @param results
	 * @return
	 * @throws SQLException 
	 */
	private Car buildFromResultSet(ResultSet results) throws SQLException {
		Car car = new Car();
		car.setId(results.getLong("id"));
		car.setDescription(results.getString("description"));
		car.setPhone(results.getString("phone"));
		return car;
	}
	
	public boolean addCar(Car car) throws SQLException {
		String query = "INSERT INTO car (description, phone) VALUES ('%s', '%s')";
		query = String.format(query, car.getDescription(), car.getPhone());
		Connection conn = null;
		try {
			// connect to database
			 conn = new DbConnector(dbName).getDbConnection();
			
			// statement allows execution of queries
			Statement dbStatement = conn.createStatement();
			
			// execute query
			return dbStatement.execute(query);
			
		}finally {
			if(conn != null)
				conn.close();
		}
	}
}
