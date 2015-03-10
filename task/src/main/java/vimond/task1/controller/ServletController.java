package vimond.task1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletController extends HttpServlet  {


	private static final long serialVersionUID = 1L;
	
	public  ServletController() {
		// TODO Auto-generated constructor stub
	}

@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	System.out.println(req.getParameter("inclusiveInterval"));
	
}
	

}
