package test;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updates")
public class UpdateServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get roll number from session
        HttpSession session = request.getSession();
        String rollNumber = (String) session.getAttribute("rollNumber");

        int enrollmentId = Integer.parseInt(request.getParameter("enrollment_id"));
        String studentName = request.getParameter("studentName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");

        // Handle enrollment date (optional)
        String enrollmentDate = null; // Initialize as null
        if (request.getParameter("enrollmentDate") != null && !request.getParameter("enrollmentDate").isEmpty()) { // Check if provided and not empty
            enrollmentDate = request.getParameter("enrollmentDate");
        }

        try {
            StudentModel.updateStudentInCourse(rollNumber, courseId, enrollmentDate, studentName, email, phone, courseName);
            response.sendRedirect("success.jsp"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database exceptions
            response.sendRedirect("error.jsp"); // Redirect to error page
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions
            response.sendRedirect("error.jsp"); // Redirect to error page
        }
    }
}
