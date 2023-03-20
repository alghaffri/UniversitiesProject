package UniversitiesProjectMainPackage;

import java.sql.*;

public class APIToDatabase {
  public static void main(String[] args) {
    // Initialize connection parameters
    String serverName = "localhost";
    String databaseName = "UniTask";
    String username = "user";
    String password = "password";

    try {
      // Load the JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      // Set connection properties
      String connectionUrl = "jdbc:sqlserver://" + serverName +
        ":1433;databaseName=" + databaseName + ";user=" + username + ";password=" + password + ";";
      Connection conn = DriverManager.getConnection(connectionUrl);

      // Execute a SQL query
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM universities");

      // Process the query results
      while (rs.next()) {
        System.out.println(rs.getString("name") + ", " + rs.getString("country") + ", " + rs.getString("state_province"));
      }

      // Close the database connection
      rs.close();
      stmt.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
