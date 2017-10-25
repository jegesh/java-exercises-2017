package animal.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AnimalDal {
private String dbName;
	
	public AnimalDal(String dbName) {
		this.dbName = dbName;
	}

	public List<Animal> getAnimals() throws SQLException {
		String query = "SELECT * FROM animal";
		
		// connect to database
		Connection conn = null;
		
		try {
			conn = new DbConnector(dbName).getDbConnection();
			
			// statement allows execution of queries
			Statement dbStatement = conn.createStatement();
			
			// result set contains the data from the database
			ResultSet results = dbStatement.executeQuery(query);
			
			List<Animal> animals = new ArrayList<>();
			
			// iterate over the result set and extract the Animal objects
			while(results.next()) {
				Animal animal = buildFromResultSet(results);
				animals.add(animal);
			}
			
			return animals;
			
		}finally {
			if(conn != null)
				conn.close();
		}
		
	}
	
	public boolean delete(long id) {
		String query = "DELETE FROM animal WHERE id = %s";
		query = String.format(query, id);
		
		Connection conn = null;
		
		try {
			conn = new DbConnector(dbName).getDbConnection();
			
			// statement allows execution of queries
			Statement dbStatement = conn.createStatement();
			dbStatement.execute(query);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
	 * this method builds a Animal object by parsing the raw data from the database
	 * @param results
	 * @return
	 * @throws SQLException 
	 */
	private Animal buildFromResultSet(ResultSet results) throws SQLException {
		Animal animal = new Animal();
		animal.setId(results.getLong("id"));
		animal.setName(results.getString("name"));
		animal.setSpecies(results.getString("species"));
		animal.setAge(results.getInt("age"));
		return animal;
	}
	
	public boolean addAnimal(Animal animal) throws SQLException {
		String query = "INSERT INTO animal (name, species, age) VALUES ('%s', '%s',%s)";
		query = String.format(query, animal.getName(), animal.getSpecies(), animal.getAge());
		Connection conn = null;
		try {
			// connect to database
			 conn = new DbConnector(dbName).getDbConnection();
			
			// statement allows execution of queries
			Statement dbStatement = conn.createStatement();
			
			// execute query
			dbStatement.execute(query);
			return true;
		}finally {
			if(conn != null)
				conn.close();
		}
	}
}
