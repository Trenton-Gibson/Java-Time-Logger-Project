package Time_Logger_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Tasks {
long Task_ID,Task_CatID;
String Task_Type,inMessage,Description;
public String Messenger(String inMessage, String Task_Type,String Description) {
	this.inMessage = inMessage;
	this.Task_Type= Task_Type;
	this.Task_CatID=Task_CatID;
	this.Description=Description;
	try {
	Connection con=DB_Connectivity.DB_Connector();
	Statement stmnt=con.createStatement();
	ResultSet Result = stmnt.executeQuery("SELECT *FROM task_category OrderBy ORDER BY Task_CatID DESC LIMIT 1 OFFSET 0"); 
	while(Result.next()){
	this.Task_CatID=Result.getLong(1);
	}
	}
	catch(Exception e) {
		System.out.println("Failed to get Task_CatID for the tasks table.");
	}
	Insert();
	String outMessage = "[Null]";
	//if (inMessage.substring(0,4).equals("Init")) {initTaskCat();}
	return outMessage;
}

public void Insert() {
	try {
	Connection con=DB_Connectivity.DB_Connector();	
	Statement stmnt=con.createStatement();
	System.out.println("Created connection for tasks data insertion");
	ResultSet res=stmnt.executeQuery("SELECT *FROM task_category ORDER BY Task_CatID DESC LIMIT 1 OFFSET 0;");
	System.out.println("Retrieved Task_CatID.");
	while(res.next()) {
	this.Task_CatID=res.getLong("Task_CatID");
	}
	System.out.println("Changed Task_CatID attribute.");
	//The question marks are parameters you can fill with variables
	String query="INSERT INTO tasks(Task_Type,Task_CatID,Description) VALUES (?,?,?)";
	//This allows for queries(beyond just selecting) to be executed in the code
	PreparedStatement pstmnt=con.prepareStatement(query);
	//these statements set the parameters with the numbers preceding the attributes designating their position
	//in the query
	pstmnt.setString(1,this.Task_Type);
	pstmnt.setLong(2,this.Task_CatID);
	pstmnt.setString(3, this.Description);
	//This executes any updates to the database (updating, deleting, create, dropping and inserting)
	pstmnt.executeUpdate();
	//This closes the database connection.
	DB_Connectivity.DB_Disconnector();
	}
	catch(Exception e) {
	System.out.println("Exception while inserting into tasks!");
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
//References:
//Task_CatID selection in insert method-https://www.tutorialspoint.com/how-can-i-select-the-row-with-the-highest-id-in-mysql