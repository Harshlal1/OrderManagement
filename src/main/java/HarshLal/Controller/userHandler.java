package HarshLal.Controller;


import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class UserHandler implements HttpHandler  {

	
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
	  	 
	  	 
	  	 
	  	 
	  	 public String GetMethod(HttpExchange exchange) {
	  		 
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
	   * To progess the Request and Generate Responses
	   * 
	   * 
	   * -----------------------------------------------------------------------------------
	   */	 
	    
}
