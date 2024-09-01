package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String rollNumber = request.getParameter("rollNumber");
        
        String name = request.getParameter("name");
        System.out.println(name);
        String dateOfBirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String enrollmentDate = request.getParameter("enrollmentDate");
        String programId = request.getParameter("programId");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO student (rollNumber, student_id, name, date_of_birth, gender, email, phone_number, address, enrollment_date, program_id) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, rollNumber);
            ps.setString(2, rollNumber);
            ps.setString(3, name);
            ps.setString(4, dateOfBirth);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, phoneNumber);
            ps.setString(8, address);
            ps.setString(9, enrollmentDate);
            ps.setString(10, programId);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("ShowData.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("err.jsp");
        }
    }
}
