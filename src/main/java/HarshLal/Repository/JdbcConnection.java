package HarshLal.Repository;

import java.sql.*;
import java.util.ArrayList;

import HarshLal.Config.DbConfig;

public class JdbcConnection {

	
    public static String setDataProduct(ArrayList data) {
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
    
    public static String setDataOrder(ArrayList data) {
    	System.out.println("Inside setData");
    		String Query="INSERT INTO \"ORDER_TABLE\" VALUES (?, ?, ?, ?,?)";
       
        try {
        	Timestamp timestamp =
        		    Timestamp.valueOf((String) data.get(3));

        		
        	Connection con=DbConfig.getConnection();
			// Statement st=con.createStatement();
        	PreparedStatement st=con.prepareStatement(Query); //In PreparedStatement it will auto close connection.
        	st.setInt(1, Integer.parseInt((String) data.get(0)));
        	st.setInt(2, Integer.parseInt((String) data.get(1)));
        	st.setInt(3, Integer.parseInt((String) data.get(2)));
        	st.setTimestamp(4, timestamp);
        	st.setNull(5, Types.TIMESTAMP);
        	
        	System.out.println("ST: "+st.toString());
        	
        	int rows = st.executeUpdate();
        	
        	
        	System.out.println("rows: "+rows);
        	
			
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "";
    }
    
    public static String setDataUser(ArrayList data) {
    	System.out.println("Inside setData");
    		String Query="INSERT INTO \"USER_TABLE\" VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)";
       
        try {
        	Connection con=DbConfig.getConnection();

        	PreparedStatement st=con.prepareStatement(Query); //In PreparedStatement it will auto close connection.
        	
        	st.setInt(1, Integer.parseInt((String) data.get(0)));
        	
        	st.setString(2,  (String) data.get(1));
        	
        	st.setString(3, (String) data.get(2));

        	st.setString(4, (String) data.get(3));

        	st.setString(5, (String) data.get(4));

        	st.setString(6, (String) data.get(5));

        	st.setString(7, (String) data.get(6));

        	st.setString(8, (String) data.get(7));

        	st.setString(9, (String) data.get(8));
        	
        	st.setString(10, (String) data.get(9));
        	
        	st.setString(11, (String) data.get(10));


        	
        	
        	
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
