

1. **Setup MySQL Database**  
   - Ensure MySQL is installed and running.  
   - Create a database and an `Employee` table with columns `EmpID`, `Name`, and `Salary`.

2. **Update Database Credentials**  
   - Replace `your_database`, `your_username`, and `your_password` in the code with actual database credentials.

3. **Add MySQL JDBC Driver**  
   - Download and add `mysql-connector-java.jar` to your project’s classpath.

4. **Compile and Run the Program**  
   - Compile: `javac MySQLConnection.java`  
   - Run: `java MySQLConnection`

5. **Verify Output**  
   - Ensure that employee records are displayed correctly from the database.


   import java.sql.*;

public class FetchEmployeeData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Update DB name
        String user = "root"; // Update username
        String password = "password"; // Update password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Employee")) {

            System.out.println("EmpID\tName\tSalary");
            while (rs.next()) {
                int empId = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(empId + "\t" + name + "\t" + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
