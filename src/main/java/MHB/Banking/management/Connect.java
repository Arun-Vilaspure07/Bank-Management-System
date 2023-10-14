package MHB.Banking.management;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	Connection c;
	Statement s;

	public Connect() {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Paarth@007");
			s = c.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
