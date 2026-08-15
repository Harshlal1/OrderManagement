package HarshLal.Controller;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ProductHandler implements HttpHandler{
	 @Override
	    public void handle(HttpExchange exchange) throws IOException {
	        String response = "Product Handler";

	        exchange.sendResponseHeaders(200, response.length());

	        exchange.getResponseBody().write(response.getBytes());
	        exchange.getResponseBody().close();
	    }

}
