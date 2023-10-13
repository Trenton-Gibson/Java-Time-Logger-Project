package Time_Logger_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Time_Transactions {
double Hours;
String StartDate, EndDate,
End_Day_of_Week, End_Time,Start_Day_of_Week, 
Start_Time, inMessage;
long TaskID,TransactionID;
public String Messenger(String inMessage, String StartDate, String Start_Day_of_Week,String End_Day_of_Week,
						String EndDate, String End_Time,String Start_Time,double Hours) {
	this.inMessage = inMessage;
	this.Hours= Hours;
	this.StartDate=StartDate;
	this.EndDate=EndDate;
	this.End_Day_of_Week=End_Day_of_Week;
	this.End_Time=End_Time;
	this.Start_Day_of_Week=Start_Day_of_Week;
	this.Start_Time=Start_Time;
	Insert();
	String outMessage = "[Null]";
	//if (inMessage.substring(0,4).equals("Init")) {initTaskCat();}
	return outMessage;
}
public void Insert() {
	try {
	Connection con=DB_Connectivity.DB_Connector();
	Statement stmnt=con.createStatement();
	ResultSet r=stmnt.executeQuery("SELECT *FROM tasks ORDER BY Task_ID DESC LIMIT 1 OFFSET 0;");
	while(r.next()) {
	this.TaskID=r.getLong("Task_ID");
	}
	System.out.println("Got the new Task_ID for time_transactions data insertion");
	//The question marks are parameters you can fill with variables
	String query="INSERT INTO time_transactions(Hours, Start_Date,"
			+ "End_Date, End_Day_of_Week, End_Time"
			+ ",Start_Day_of_Week, Start_Time, Task_ID) VALUES (?,?,?,?,?,?,?,?)";
	//This allows for queries(beyond just selecting) to be executed in the code
	PreparedStatement pstmnt=con.prepareStatement(query);
	//these statements set the parameters with the numbers preceding the attributes designating their position
	//in the query
	pstmnt.setDouble(1,this.Hours);
	pstmnt.setString(2, this.StartDate);
	pstmnt.setString(3, this.EndDate);
	pstmnt.setString(4,this.End_Day_of_Week);
	pstmnt.setString(5,this.End_Time);
	pstmnt.setString(6,this.Start_Day_of_Week);
	pstmnt.setString(7,this.Start_Time);
	pstmnt.setLong(8, this.TaskID);
	System.out.println("Assigned all the attributes to the prepared stament in time_transactions insert method.");
	//This executes any updates to the database (updating, deleting, create, dropping and inserting)
	pstmnt.executeUpdate();
	System.out.println("Added all the time_transactions insert data.");
	//This closes the database connection.
	DB_Connectivity.DB_Disconnector();
	}
	catch(Exception e) {
	System.out.println("Exception while inserting into time_transactions!");
	}
}
public void Delete() {
	try {
	//This connects the class to the correct database driver.
			//The driver must be in the package your operating in.
			System.out.println("Beginning");
			Class.forName("com.mysql.cj.jdbc.Driver");
			//This forms the connection with the database.
			//The first argument is the connection url ,and the database of choice is referenced in the area beyond the last backslash.
			//The second argument is the username for the database.
			//The final argument is for the password for the database.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/time_logger", "root","Sweatshirt77");
			System.out.println("Connected With the database successfully");
			//The question marks are parameters you can fill with variables
			String query="";
			//This allows for queries(beyond just selecting) to be executed in the code
			PreparedStatement pstmnt=con.prepareStatement(query);
			//This executes any updates to the database (updating, deleting, create, dropping and inserting)
			pstmnt.executeUpdate();
			System.out.println("Deleted Data");
			//This form of statement can only execute hard coded queries
			Statement stmnt=con.createStatement();
			ResultSet result=stmnt.executeQuery("SELECT * FROM task_category");
			System.out.println("Selected Data");
			//This loops prints our results out to the screen
			while(result.next()) {
			System.out.println(result.getInt(1)+" "+result.getString(2));
			}
			//This closes the database connection.
			con.close();
			}
			catch(Exception e) {
			System.out.println("Exception!");
			}
}
public void Update () {
	try {
	//This connects the class to the correct database driver.
			//The driver must be in the package your operating in.
			System.out.println("Beginning");
			Class.forName("com.mysql.cj.jdbc.Driver");
			//This forms the connection with the database.
			//The first argument is the connection url ,and the database of choice is referenced in the area beyond the last backslash.
			//The second argument is the username for the database.
			//The final argument is for the password for the database.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/time_logger", "root","Sweatshirt77");
			System.out.println("Connected With the database successfully");
			//The question marks are parameters you can fill with variables
			String query="UPDATE task_category FROM task_category";
			//This allows for queries(beyond just selecting) to be executed in the code
			PreparedStatement pstmnt=con.prepareStatement(query);
			//This executes any updates to the database (updating, deleting, create, dropping and inserting)
			pstmnt.executeUpdate();
			System.out.println("Deleted Data");
			//This form of statement can only execute hard coded queries
			Statement stmnt=con.createStatement();
			ResultSet result=stmnt.executeQuery("SELECT * FROM task_category");
			System.out.println("Selected Data");
			//This loops prints our results out to the screen
			while(result.next()) {
			System.out.println(result.getInt(1)+" "+result.getString(2));
			}
			//This closes the database connection.
			con.close();
			}
			catch(Exception e) {
			System.out.println("Exception!");
			}
}
}
