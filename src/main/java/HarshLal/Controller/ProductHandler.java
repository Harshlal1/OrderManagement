package HarshLal.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import HarshLal.Repository.JdbcConnection;

public class ProductHandler implements HttpHandler{
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
			
			
			
			 String response = processPostRequest(requestBody);
			 

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
			
			 String response = "Product Handler";

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
			
			 String response = "Product Handler";

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
			
			 String response = "Product Handler";

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
    	   String name="";
    	   int id;
    	   int quantity;
    	   float price;
    	   try {
    	   JSONObject jsonObject=new JSONObject(requestBody);
    	   
    	   JSONObject data=jsonObject.getJSONObject("data");
    	   
    	   name=data.getString("name");
    	   id=data.getInt("id");
    	   quantity=data.getInt("quantity");
    	   price=data.getFloat("price");
    	   
    	   
    	   
    	   ArrayList<String> value=new ArrayList();
    	   
    	   
    	   value.add(String.valueOf(id)); //1
    	   value.add(name);				  //2
    	   value.add(String.valueOf(price)); //3
    	   value.add(String.valueOf(quantity)); //4
    	  
    	   
    	   System.out.println("before dbResponse");
    	   
    	   JdbcConnection jd=new JdbcConnection();
    	  String dbResponse =jd.setDataProduct(value);
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

}
