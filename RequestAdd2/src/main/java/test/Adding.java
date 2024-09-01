package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Adding  extends HttpServlet{
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	        String snum1 = req.getParameter("num1");
	        String snum2 = req.getParameter("num2");
	        int num1 = Integer.parseInt(snum1);
	        int num2 = Integer.parseInt(snum2);
	        int sum = num1 + num2;
	        RequestDispatcher rd =req.getRequestDispatcher("sq");
	        rd.forward(req, res);
	    }}