package test;

import java.io.IOException;

import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get roll number from session
        HttpSession session = request.getSession();
        String rollNumber = (String) session.getAttribute("rollNumber");

        try {
            StudentModel.deleteEnrollment(rollNumber);
            // Redirect to success page (assuming success.jsp exists)
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database exceptions (log or display error message)
            response.sendRedirect("error.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions
            response.sendRedirect("error.jsp");
        }
    }
}
