package HarshLal.Repository;

import java.sql.*;
import java.util.ArrayList;

import HarshLal.Config.DbConfig;

public class JdbcConnection {

	
    public static String setData(ArrayList data) {
    	System.out.println("Inside setData");
    		String Query="INSERT INTO \"PRODUCT_TABLE\" VALUES (?, ?, ?, ?)";
       
        try {
        	Connection con=DbConfig.getConnection();
			// Statement st=con.createStatement();
        	PreparedStatement st=con.prepareStatement(Query); //In PreparedStatement it will auto close connection.
        	st.setInt(1, Integer.parseInt((String) data.get(0)));
        	st.setString(2, (String) data.get(1));
        	st.setFloat(3, Float.parseFloat((String) data.get(2)));
        	st.setInt(4, Integer.parseInt((String) data.get(3)));
        	
        	System.out.println("ST: "+st.toString());
        	
        	int rows = st.executeUpdate();
        	
        	
        	System.out.println("rows: "+rows);
        	
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "";
    }
}
