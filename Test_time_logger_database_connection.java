package Time_Logger_Classes;
import java.sql.*;
public class Test_time_logger_database_connection {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			//This connects the class to the correct database driver.
			//The driver must be in the package your operating in.
			Class.forName("com.mysql.cj.jdbc.Driver");
			//This forms the connection with the database.
			//The first argument is the connection url ,and the database of choice is referenced in the area beyond the last backslash.
			//The second argument is the username for the database.
			//The final argument is for the password for the database.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/time_logger", "root","Sweatshirt77");
			System.out.println("Connected With the database successfully");
			//This allows for queries to be executed in the code
			Statement stmnt=con.createStatement();
			System.out.println("Hello");
			ResultSet result=stmnt.executeQuery("SELECT * FROM task_category");
			while(result.next()) {
			System.out.println(result.getInt(1)+" "+result.getString(2));
			}
			//This closes the database connection.
			con.close();
			} 
	}

