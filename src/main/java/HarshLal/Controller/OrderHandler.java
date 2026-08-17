package HarshLal.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import HarshLal.Repository.JdbcConnection;

public class OrderHandler implements HttpHandler{
	
	 @Override
	    public void handle(HttpExchange exchange) throws IOException {
		 
		 String method = exchange.getRequestMethod(); //To get which method is used POST,GET,PUT,DELETE
		 
		 if(method.equalsIgnoreCase("POST")) {
			 
			 PostMethod(exchange);
			 
		 }else  if(method.equalsIgnoreCase("GET")) {
			 
			 PostMethod(exchange);
			 
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
			
			processPostRequest(requestBody);
			
			 String response = "order Handler";

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
			
			 String response = "order Handler";

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
			
			 String response = "order Handler";

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
			
			 String response = "order Handler";

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
    	   int user_id;
    	   int product_id;
    	   String order_date="";
    	   String delivery_date="";
    	   
    	   try {
    	   JSONObject jsonObject=new JSONObject(requestBody);
    	   
    	   JSONObject data=jsonObject.getJSONObject("data");
    	   
    	   id=data.getInt("id");
    	   user_id=data.getInt("user_id");
    	   product_id=data.getInt("product_id");
    	   order_date=data.getString("order_date");
    	   delivery_date=data.getString("delivery_date");
    	   
    	   
    	   
    	   ArrayList<String> value=new ArrayList();
    	   
    	   
    	   value.add(String.valueOf(id)); //1
    	   value.add(String.valueOf(user_id));				  //2
    	   value.add(String.valueOf(product_id)); //3
    	   value.add(order_date); //4
    	   value.add(delivery_date); //5
    	  
    	   
    	   System.out.println("before dbResponse");
    	   
    	   JdbcConnection jd=new JdbcConnection();
    	  String dbResponse =jd.setDataOrder(value);
    	  System.out.println("after dbResponse");
    	  
    	  
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }
    	   
    	   return response;
       }

 

}
