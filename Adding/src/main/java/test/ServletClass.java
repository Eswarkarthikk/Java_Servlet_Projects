package test;e
import java.io.*;
import javax.servlet.http.*;
public class ServletClass extends HttpServlet{

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	        String snum1 = req.getParameter("num1");
	        String snum2 = req.getParameter("num2");

	        int num1 = Integer.parseInt(snum1);
	        int num2 = Integer.parseInt(snum2);

	        int sum = num1 + num2;

	        PrintWriter out = res.getWriter();
	        out.println("sum is :" + sum);
	    }
	}

