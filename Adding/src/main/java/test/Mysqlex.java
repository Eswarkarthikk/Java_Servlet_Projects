package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Mysqlex {
	public static void main(String[] args) {
/*		String url =" ";
		String username=" ";
		String Password="";
		Connection connection =null;
		Statement statement =null;
		ResultSet resultset=null;
		try {
			class.forName("com.mysql.cj.jdbc.Driver");
			Connection = DriverManager.getConnection(url,username,password);
			statement =connection.createStatement();
			Stringquery="SELECT * FROM student";
			resultset=statement.executeQuery(query);
			while(resultset.next()) {
				String column1value=resultset.getString("email");
				System.out.println("value of column1 :"+column1value);
			}
		}
		*/
        String dbName = "jdbc:postgresql://localhost/resucraft";
        String dbDriver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "1234"; 

        try{
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbName, userName, password);
        System.out.println("Got Connection");
        Statement statement = con.createStatement();
        String sql = "select * from resucraft_userdata";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("uname"));
        }}
        
        
        catch(SQLException e){
           e.printStackTrace();
        }
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
