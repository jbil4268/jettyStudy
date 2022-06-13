package test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.gson.JsonElement;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static String myUrl = "";
	
	public MyServlet(JsonElement json) {
		System.out.println("publish");
		//System.out.println(json.toString());
		myUrl = json.getAsJsonObject().get("key").getAsString();
		System.out.println(myUrl);
	}
	
	public void init(ServletConfig config) throws ServletException {
        System.out.println("init called") ;
        super.init() ;
    }
	
	public void setJson(JsonElement json) {
		System.out.println(json.toString());
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet");
		System.out.println(myUrl);
		res.setStatus(200);
		//res.getWriter().write("Hello!");
		res.getWriter().write(myUrl);
	}
}
