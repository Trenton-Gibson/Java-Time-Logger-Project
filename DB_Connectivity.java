package Time_Logger_Classes;
import java.sql.*;
import java.util.*;

public class DB_Connectivity {
	static Connection con;
public static Connection DB_Connector() {
	
	try {
	//This connects the class to the correct database driver.
	//The driver must be in the package your operating in.
	Class.forName("com.mysql.cj.jdbc.Driver");
	//This forms the connection with the database.
	//The first argument is the connection url ,and the database of choice is referenced in the area beyond the last backslash.
	//The second argument is the username for the database.
	//The final argument is for the password for the database.
	Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/time_logger", "root","Sweatshirt77");
	con=connect;
	}
	catch (Exception e) {
		System.out.println("Failed to connect to database.");
	}
	return con;
}
public static void DB_Disconnector() {
	try {
	con.close();
	}
	catch(Exception e) {
		System.out.println("Failed to disconnect from database.");
	}
}
}
