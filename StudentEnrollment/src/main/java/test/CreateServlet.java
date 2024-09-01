package test;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get roll number from session
        HttpSession session = request.getSession();
        String rollNumber = (String) session.getAttribute("rollNumber");

        String studentName = request.getParameter("studentName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");
        String enrollmentDate = request.getParameter("enrollmentDate"); // Including enrollment date

        try {
            StudentModel.enrollStudentInCourse(rollNumber, courseId, enrollmentDate, studentName, email, phone, courseName); // Pass enrollmentDate
            response.sendRedirect("success.jsp"); // Redirect to success page
        } catch (Exception e) {
            e.printStackTrace();
            // Handle potential exceptions (e.g., database errors)
            response.sendRedirect("error.jsp"); // Redirect to error page
        }
    }
}
