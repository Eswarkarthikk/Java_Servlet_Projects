package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class sq extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		int num3 = Integer.parseInt((String) (req.getAttribute("sum")));
		PrintWriter out = res.getWriter();
		out.println("num:"+num3);
	}
}
