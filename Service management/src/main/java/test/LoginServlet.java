package test;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollNumber = request.getParameter("rollNumber");
        String username = request.getParameter("password");

        try {
            // Check if user exists in database
            if (ServiceModel.validateUser(rollNumber, username)) {
                // Login successful - Create a session and store roll number
                HttpSession session = request.getSession(true); // Create session if not existing
                session.setAttribute("rollNumber", rollNumber);
                session.setAttribute("username", username);
                response.sendRedirect("success.jsp"); // Redirect to success page
            } else {
                // User not found - Add user and redirect to welcome page
            	 HttpSession session = request.getSession(true); // Create session if not existing
                 session.setAttribute("rollNumber", rollNumber);
                 session.setAttribute("username", username);
                ServiceModel.addUser(rollNumber, username);
                response.sendRedirect("success.jsp"); // Redirect to welcome page after adding user
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately (e.g., display a generic error message)
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Database error occurred! Please try again.</h3>");
            out.println("</body></html>");
        }
    }
}
