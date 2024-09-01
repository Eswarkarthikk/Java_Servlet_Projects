package test;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceIdStr = request.getParameter("serviceId");
        if (serviceIdStr != null && !serviceIdStr.isEmpty()) {
            try {
                int serviceId = Integer.parseInt(serviceIdStr);
                ServiceModel.deleteService(serviceId);
                response.sendRedirect("show.jsp"); // Redirect to a page showing all services
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp"); // Redirect to an error page or display an error message
            }
        } else {
            response.sendRedirect("delete.jsp"); // Redirect back to delete.jsp if serviceId is not provided
        }
    }
}
