package animal.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDal {

	public User getByName(String name) throws SQLException {
		String query = "SELECT * FROM user WHERE username = '%s'";
		ResultSet rs = new DbConnector(DbConnector.DB_PRODUCTION)
				.getDbConnection()
				.createStatement()
				.executeQuery(String.format(query, name));
		return buildUserFromResultSet(rs);
	}
	
	private User buildUserFromResultSet(ResultSet rs) throws SQLException {
		User user = new User();
		rs.next();
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setUsername(rs.getString("username"));
		user.setId(rs.getLong("id"));
		
		return user;
	}
}
