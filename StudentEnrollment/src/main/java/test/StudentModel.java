package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentModel {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/enrollmentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Failed to load JDBC driver");
        }
    }

    public static boolean validateUser(String rollNumber, String username) throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT * FROM login WHERE roll_number = ? AND username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, rollNumber);
        statement.setString(2, username);
        ResultSet resultSet = statement.executeQuery();
        boolean isValid = resultSet.next();
        resultSet.close();
        statement.close();
        connection.close();
        return isValid;
    }

    	  public static boolean hasStudentData(String rollNumber) throws SQLException {
    	    Connection connection = getConnection();
    	    String query = "SELECT * FROM studentcourse WHERE student_roll_number = ?";
    	    PreparedStatement statement = connection.prepareStatement(query);
    	    statement.setString(1, rollNumber);
    	    ResultSet resultSet = statement.executeQuery();
    	    boolean hasData = resultSet.next();
    	    resultSet.close();
    	    statement.close();
    	    connection.close();
    	    return hasData;
    	  }

    	  // You can add methods to retrieve enrolled courses based on student roll number, etc.
    	

    // This method might not be applicable anymore depending on your data structure
    // public static boolean isStudentPresent(String rollNumber) throws SQLException {
    //     // Implement logic to check if student exists based on roll number (if needed)
    // }

    public static void updateStudentInCourse(String studentRollNumber, int courseId, String enrollmentDate, String studentName, String email, String phone, String courseName) throws SQLException {
        Connection connection = getConnection();
        String query = "UPDATE StudentCourse SET course_id = ?, enrollment_date = ?, student_name = ?, email = ?, phone = ?, course_name = ? WHERE student_roll_number = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, courseId);
        statement.setString(2, enrollmentDate);
        statement.setString(3, studentName);
        statement.setString(4, email);
        statement.setString(5, phone);
        statement.setString(6, courseName);
        statement.setString(7, studentRollNumber);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public static void deleteEnrollment(String studentRollNumber) throws SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM StudentCourse WHERE student_roll_number = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, studentRollNumber);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public static void enrollStudentInCourse(String studentRollNumber, int courseId, String enrollmentDate, String studentName, String email, String phone, String courseName) throws SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO StudentCourse (student_roll_number, course_id, enrollment_date, student_name, email, phone, course_name) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, studentRollNumber);
        statement.setInt(2, courseId);
        statement.setString(3, enrollmentDate);
        statement.setString(4, studentName);
        statement.setString(5, email);
        statement.setString(6, phone);
        statement.setString(7, courseName);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public static void addUser(String rollNumber, String username) throws SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO login (roll_number, username) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, rollNumber);
        statement.setString(2, username);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    // You can add methods to retrieve enrolled courses based on student roll number, etc.
}
