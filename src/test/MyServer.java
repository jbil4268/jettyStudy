package test;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MyServer {

	public static void main(String[] args) throws Exception {
		new MyServer().start();
	}

	public void start() throws Exception {
		
		JsonElement jsonElement = JsonParser.parseString("{ \"key\":\"value\" }");
		
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(new ServletHolder(new MyServlet(jsonElement)), "/test");
		servletHandler.addServletWithMapping(MyServlet.class, "/mypath");
		server.setHandler(servletHandler);

		server.start();
		server.join();
	}
}
