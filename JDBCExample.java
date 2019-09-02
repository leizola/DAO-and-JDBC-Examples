import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {
  //Starts opening a connection, and setting the URL , Username and the password of the same
  
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employees", "root", "mysql123");
		System.out.println("Conectado!\n");
    
//Now create the object STATEMENT and RESULTSET, both to use the JDBC connection, Statement it's used to create and return the value of
//the wanted Statement and resultset can now be used where any SQL query could be writed on it.

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from departments");
		
		System.out.println("# TABELA DEPARTMENTS #");
		//The while loop in this case, it's applied to return the resultset , while still have one.
    while (resultSet.next()) {
			System.out.println(resultSet.getString("dept_no") + " | " + resultSet.getString("dept_name"));
		}
		
    //After that the objects used must be closed
    
		resultSet.close();
		statement.close();
		connection.close();
	}

}
