package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceModel {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/servicedb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Inner class to hold service data
    public static class Service {
        private int serviceId;
        private String name;
        private String description;
        private float price;

        public Service(int serviceId, String name, String description, float price) {
            this.serviceId = serviceId;
            this.name = name;
            this.description = description;
            this.price = price;
        }

        public int getServiceId() {
            return serviceId;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public float getPrice() {
            return price;
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Failed to load JDBC driver");
        }
    }
    public static boolean validateUser(String rollNumber, String password) throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT * FROM login WHERE roll_number = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, rollNumber);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        boolean isValid = resultSet.next();
        resultSet.close();
        statement.close();
        connection.close();
        return isValid;
    }

    public static void addUser(String rollNumber, String password) throws SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO login (roll_number, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, rollNumber);
        statement.setString(2, password);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    // Method to get service by ID
    public static Service getServiceById(int serviceId) throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT * FROM service WHERE service_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, serviceId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("service_id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            float price = resultSet.getFloat("price");
            resultSet.close();
            statement.close();
            connection.close();
            return new Service(id, name, description, price);
        } else {
            resultSet.close();
            statement.close();
            connection.close();
            return null; // No service found with this ID
        }
    }

    // Method to add a new service
    public static void NewService(String name, String description, float price) throws SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO service (name, description, price) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setFloat(3, price);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    // Method to update an existing service
    public static void updateService(int serviceId, String name, String description, float price) throws SQLException {
        Connection connection = getConnection();
        String query = "UPDATE service SET name = ?, description = ?, price = ? WHERE service_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setFloat(3, price);
        statement.setInt(4, serviceId);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    // Method to delete a service by ID
    public static void deleteService(int serviceId) throws SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM service WHERE service_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, serviceId);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    // Method to retrieve all services
    public static List<Service> getAllServices() throws SQLException {
        List<Service> services = new ArrayList<>();
        Connection connection = getConnection();
        String query = "SELECT * FROM service";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("service_id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            float price = resultSet.getFloat("price");
            services.add(new Service(id, name, description, price));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return services;
    }
}
