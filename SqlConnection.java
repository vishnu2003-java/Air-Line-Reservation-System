package airline;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {

	
	public static Connection SQLConnector() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinereservationsystem","root","Vish3548nu11.");
        return con;
	}
	
}

