package HarshLal.OrderManagement;


import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class UserHandler implements HttpHandler  {

	
	  @Override
	    public void handle(HttpExchange exchange) throws IOException {
	        String response = "Hello! Harsh";

	        exchange.sendResponseHeaders(200, response.length());

	        exchange.getResponseBody().write(response.getBytes());
	        exchange.getResponseBody().close();
	    }
}
