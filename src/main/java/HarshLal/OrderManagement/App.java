package HarshLal.OrderManagement;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

import HarshLal.Controller.UserHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	HttpServer server = HttpServer.create(
    		    new InetSocketAddress(8080), 0
    		);

    		server.createContext("/users", new UserHandler());

    		server.start();
        System.out.println( "Server Started" );
    }
}
