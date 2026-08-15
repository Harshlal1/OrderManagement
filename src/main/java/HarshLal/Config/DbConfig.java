package HarshLal.Config;

import java.sql.*;

public class DbConfig {
	private static final String url="jdbc:postgresql://localhost:5432/JDBC";
	private static final  String username="postgres";
	private static final   String pass="Harsh@123";
	
	 public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, pass);
	    }

}
