import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tema5Practica0 {
  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");

      String query = "SELECT * FROM EMPLOYEE WHERE DEPARTMENT_ID = 30";

      statement = connection.createStatement();

      resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        int employeeId = resultSet.getInt("EMPLOYEE_ID");
        String lastName = resultSet.getString("LAST_NAME");
        String firstName = resultSet.getString("FIRST_NAME");
        float departmentId = resultSet.getFloat("DEPARTMENT_ID");

        System.out.println("Empleado ID " + employeeId +
            ", NOMBRE: " + firstName +
            ", APELLIDO: " + lastName +
            ", DEPARTAMENTO: " + departmentId);
      }

    } catch (SQLException e) {
      System.out.println("Ha ocurrido excepción " + e.getMessage() + " " + e.getSQLState());

    } finally {
      try {
        if (resultSet != null)
          resultSet.close();
        if (statement != null)
          statement.close();
        if (connection != null)
          connection.close();
      } catch (SQLException e) {
      }
    }
  }
}
