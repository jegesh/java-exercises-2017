package electric.college.test.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDal {
	
	private Currency buildObject(ResultSet rs) throws SQLException {
		
		Currency c = new Currency();
		c.setId(rs.getLong("id"));
		c.setName(rs.getString("name"));
		c.setRate(rs.getDouble("rate"));
		return c;
	}
	
	public Currency get(String name) throws SQLException {
		DbConnector connector = new DbConnector();
		ResultSet rs = connector.getDbConnection()
				.createStatement()
				.executeQuery(
						String.format("SELECT * FROM currency WHERE name = '%s'", name));
		rs.next();
		return buildObject(rs);
	}

}
