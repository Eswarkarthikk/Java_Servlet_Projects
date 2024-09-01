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

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String rollNumber = (String) session.getAttribute("rollNumber");
        
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
             PreparedStatement ps = conn.prepareStatement("UPDATE student SET name=?, date_of_birth=?, gender=?, email=?, phone_number=?, address=?, enrollment_date=?, program_id=1 WHERE RollNumber=?")) {
            ps.setString(1, name);
            ps.setString(2, dateOfBirth);
            ps.setString(3, gender);
            ps.setString(4, email);
            ps.setString(5, phoneNumber);
            ps.setString(6, address);
            ps.setString(7, enrollmentDate);
            ps.setString(8, rollNumber);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                response.sendRedirect("ShowData.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
