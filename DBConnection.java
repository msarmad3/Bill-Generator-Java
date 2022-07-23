package ihetesam;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static String connectionName = "com.mysql.jdbc.Driver";
	
	static Connection MySqlConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihetesam","root","");
		}
		catch(Exception ex) {
			System.out.println("Database/Server Connection Errors"+ ex.toString());
		}
		return con;
	}

}
