package electric.college.test.db;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		CurrencyDal dal = new CurrencyDal();
		Currency c = dal.get("Canadian Dollar");
		
		assert c.getId() == 4;
		assert c.getRate() == .845D;
		
		System.out.println(c);
	}
}
