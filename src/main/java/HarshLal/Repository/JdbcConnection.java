package HarshLal.Repository;

import java.sql.*;

import HarshLal.Config.DbConfig;

public class JdbcConnection {

	
    public static void getData(String Query) {

       
        try {
        	Connection con=DbConfig.getConnection();
			// Statement st=con.createStatement();
        	PreparedStatement st=con.prepareStatement(Query); //In PreparedStatement it will auto close connection.
        	ResultSet rs=st.executeQuery();
        	
			/* ResultSet rs=st.executeQuery(Query);
			 * st.close();
			 con.close();
			 */
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
