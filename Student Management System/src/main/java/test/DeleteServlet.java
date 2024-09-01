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

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String rollNumber = (String) session.getAttribute("rollNumber");

        if (rollNumber != null) {
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE rollNumber = ?")) {
                ps.setString(1, rollNumber);

                int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) { // Remove roll number from session
                    response.sendRedirect("ShowData.jsp"); // Redirect to success page
                } else {
                    response.sendRedirect("error.jsp"); // Redirect to error page
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp"); // Redirect to error page
            }
        } else {
            response.sendRedirect("error.jsp"); // Redirect to error page
        }
    }
}
