package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rollNumber = request.getParameter("rollNumber");
        String password = request.getParameter("password");
System.out.println(rollNumber);
jakarta.servlet.http.HttpSession session = request.getSession();
session.setAttribute("rollNumber", rollNumber);
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM studentdb WHERE RollNumber = ?")) {
            ps.setString(1, rollNumber);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                // Student exists, check password
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)) {
                    // Login successful
                	 
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    return;
                }
            }

            // Student is new, insert into database
            PreparedStatement insertPs = conn.prepareStatement("INSERT INTO studentdb (RollNumber, password) VALUES (?, ?)");
            insertPs.setString(1, rollNumber);
            insertPs.setString(2, password);
            insertPs.executeUpdate();
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the error
        }
    }
}
