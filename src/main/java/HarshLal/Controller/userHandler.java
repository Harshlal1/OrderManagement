package HarshLal.Controller;


import com.sun.net.httpserver.HttpHandler;

import HarshLal.Repository.JdbcConnection;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONObject;

public class UserHandler implements HttpHandler  {

	
	  @Override
	    public void handle(HttpExchange exchange) throws IOException {

			 
			 String method = exchange.getRequestMethod(); //To get which method is used POST,GET,PUT,DELETE
			 
			 if(method.equalsIgnoreCase("POST")) {
				 
				 PostMethod(exchange);
				 
			 }else  if(method.equalsIgnoreCase("GET")) {
				 
				 GetMethod(exchange);
				 
			 }else  if(method.equalsIgnoreCase("PUT")) {
				 
				 PUTMethod(exchange);
				 
			 }else  if(method.equalsIgnoreCase("DELETE")) {
				 
				 DeleteMethod(exchange);
				 
			 }else {
				 String response = "Wrong Request";

			        exchange.sendResponseHeaders(400, response.length()); //Response code 
			        exchange.getResponseBody().write(response.getBytes());
			        exchange.getResponseBody().close();
			 }
			 
			
		       
		    
		 }
	  
	  
	  /*--------------------------------------------------
	   * 
	   * To Handle request According to its Method.
	   * 
	   *  ---------------------------------------------------
	   */
	  	 
	  	 public String PostMethod(HttpExchange exchange) {
	  		 String requestBody="";
	  		 InputStream inputStream = exchange.getRequestBody(); //to read request

	  		  try {
	  			requestBody = new String(
	  			         inputStream.readAllBytes(),
	  			         StandardCharsets.UTF_8
	  			 ); //to read request
	  			
	  			System.out.println(requestBody);

	  			
	  			 String response =processPostRequest(requestBody);

	  		        exchange.sendResponseHeaders(200, response.length());

	  		        exchange.getResponseBody().write(response.getBytes());
	  		        exchange.getResponseBody().close();
	  			
	  		} catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  		 
	  		 return "";
	  	 }
	  	 
	  	 
	  	 
	  	 
	  	 public String GetMethod(HttpExchange exchange) {
	  		 
	  		 String requestBody="";
	  		 InputStream inputStream = exchange.getRequestBody(); //to read request

	  		  try {
	  			requestBody = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8); //to read request
	  			
	  			System.out.println(requestBody);
	  			
	  			processGetRequest(requestBody);
	  			
	  			 String response = "User Handler";

	  		        exchange.sendResponseHeaders(200, response.length());

	  		        exchange.getResponseBody().write(response.getBytes());
	  		        exchange.getResponseBody().close();
	  			
	  		} catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  		 return "";
	  	 }
	  	 
	  	 
	  	 
	  	 public String PUTMethod(HttpExchange exchange) {
	  		 
	  		 String requestBody="";
	  		 InputStream inputStream = exchange.getRequestBody(); //to read request

	  		  try {
	  			  requestBody = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8); //to read request
	  			
	  			System.out.println(requestBody);
	  			
	  			 String response = "User Handler";

	  		        exchange.sendResponseHeaders(200, response.length());

	  		        exchange.getResponseBody().write(response.getBytes());
	  		        exchange.getResponseBody().close();
	  			
	  		} catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  		 return "";
	  	 }
	  	 
	  	 
	  	 
	  	 public String DeleteMethod(HttpExchange exchange) {
	  		 
	  		 String requestBody="";
	  		 InputStream inputStream = exchange.getRequestBody(); //to read request

	  		  try {
	  			  requestBody = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8); //to read request
	  			
	  			System.out.println(requestBody);
	  			
	  			 String response = "User Handler";

	  		        exchange.sendResponseHeaders(200, response.length());

	  		        exchange.getResponseBody().write(response.getBytes());
	  		        exchange.getResponseBody().close();
	  			
	  		} catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  		 return "";
	  	 }
	  	 
		 
	  	/*-----------------------------------------------------------------------------------
	  	 * 
	  	 * 
	  	 * To process the Request and Generate Responses
	  	 * 
	  	 * 
	  	 * -----------------------------------------------------------------------------------
	  	 */	 
	  	       public String processPostRequest(String requestBody) {  // to create/add data 
	  	    	   System.out.println("Inside processPostRequest");
	  	    	   String response="";
	  	    	  
	  	    	   int id;
	  	    	   String name="";
	  	    	   String mobile="";
	  	    	   String email="";
		  	       String address_line1="";
		  	       String address_line2="";
		  	       String address_line3="";
		  	       String state="";
		  	       String district="";
		  	       String city="";
		  	       String pincode="";
	  	    	
	  	    	
	  	    	   try {
		  	    	   JSONObject jsonObject=new JSONObject(requestBody);
		  	    	   
		  	    	   JSONObject data=jsonObject.getJSONObject("data");
		  	    	   
			  	    	   id=data.getInt("id");
			  	    	   name=data.getString("name");
			  	    	   mobile=data.getString("mobile");
			  	    	   email=data.getString("email");
			  	    	   address_line1=data.getString("address_line1");
			  	    	   address_line2=data.getString("address_line2");
			  	    	   address_line3=data.getString("address_line3");
			  	    	   state=data.getString("state");
			  	    	   district=data.getString("district");
			  	    	   city=data.getString("city");
			  	    	   pincode=data.getString("pincode");
			  	    	   
	  	    	 
	  	    	   
	  	    	   
			  	    	   
			  	    	   ArrayList<String> value=new ArrayList();
			  	    	   
			  	    	   
			  	    	   value.add(String.valueOf(id)); //1
			  	    	   value.add(name);				  //2
				  	        value.add(mobile);				  //3
				  	    	value.add(email);				  //4
				  	    	value.add(address_line1);				  //5
				  	    	value.add(address_line2);				  //6
				  	    	value.add(address_line3);				  //7
				  	    	value.add(state);				  //8
				  	    	value.add(district);				  //9
				  	    	value.add(city);				  //10
				  	    	value.add(pincode);				  //11
			  	    	   
			  	    	  
			  	    	   
			  	    	   System.out.println("before dbResponse");
			  	    	   
			  	    	   JdbcConnection jd=new JdbcConnection();
			  	    	  String dbResponse =jd.setDataUser(value);
			  	    	  System.out.println("after dbResponse");
			  	    	  
			  	    	 JSONObject resp=new JSONObject();
			  	    	 if(dbResponse.equalsIgnoreCase("1")) {
			  	    		  resp.put("request_type", "addProduct");
			  	    		  resp.put("status", "success");
			  	    		  resp.put("respMessage", "Data Inserted Successfully");
			  	    	  }else {
			  	    		  resp.put("request_type", "addProduct");
			  	    		  resp.put("status", "Failed");
			  	    		  resp.put("respMessage", "Data Insertion Failed");
			  	    	  }
			  	    	  response=resp.toString();
			  	    	  
	  	    	  
	  	    	   }catch(Exception e) {
	  	    		   e.printStackTrace();
	  	    	   }
	  	    	   
	  	    	   return response;
	  	       }
	  	       
	  	       
	  	       
	  public String processGetRequest(String requestBody) {
	  	   
		  String response="";
		  String id="";
		  try {
 	    	   JSONObject jsonObject=new JSONObject(requestBody);
 	    	   
 	    	   JSONObject data=jsonObject.getJSONObject("data");
 	    	   
 	    	  id=String.valueOf(data.getInt("user_id"));
 	    	  
 	    	 JdbcConnection jd=new JdbcConnection();
 	    	 jd.getDataUser(id);
 	    	   
 	    	   
		  }catch(Exception e) {
	    		   e.printStackTrace();
	    	   }
	  	    	 
	  	    	 return response;
	}

	    
}
