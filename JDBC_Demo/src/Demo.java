package JDBC_Demo.src;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        String sql = "SELECT emp FROM emp WHERE id = 3";
        String url = "jdbc:mysql://localhost:3306/root"; 
        String username = "root"; 
        String password = "root"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

   
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Employee Name: " + rs.getString("ename"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
