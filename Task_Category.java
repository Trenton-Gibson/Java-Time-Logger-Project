package Time_Logger_Classes;
import java.sql.*;
import java.util.*;

public class Task_Category{
	private long Task_CatID;
	private String Task_Category, inMessage;
	
	//private void initTaskCat () {
		//Init Max toy_poodle red ring 6.9 0.8 chicken sunny
		//String junk;
		//junk = parse();
		//Task_CatID=Integer.parseInt(parse());
		//System.out.println("Number processed");
		//Task_Category=parse();
		//System.out.println("String"+Task_Category+"processed");
		//System.out.println(this.Task_CatID+" "+ this.Task_Category);
		//}
	
	public String Messenger(String inMessage, String category) {
		this.inMessage = inMessage;
		this.Task_Category= category;
		String outMessage = "[Null]";
		//if (inMessage.substring(0,4).equals("Init")) {initTaskCat();}
		Insert();
		return outMessage;
	}
	private String parse(){
  		String addto = "";
  		int len;
  		while (!(inMessage.charAt(0) == ' '))
  		{
  			addto += inMessage.charAt(0);
  			inMessage = inMessage.substring(1);
  		}
  		inMessage += " ";
  		inMessage = inMessage.substring(1);
  		return addto;
  	}
	public void Insert() {
		try {
		Connection con=DB_Connectivity.DB_Connector();	
		//The question marks are parameters you can fill with variables
		String query="INSERT INTO task_category(Task_Category) VALUES (?)";
		//This allows for queries(beyond just selecting) to be executed in the code
		PreparedStatement pstmnt=con.prepareStatement(query);
		//these statements set the parameters with the numbers preceding the attributes designating their position
		//in the query
		pstmnt.setString(1,this.Task_Category);
		//This executes any updates to the database (updating, deleting, create, dropping and inserting)
		pstmnt.executeUpdate();
		//This closes the database connection.
		DB_Connectivity.DB_Disconnector();
		}
		catch(Exception e) {
		System.out.println("Exception while inserting into task_category!");
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
//parse, and init methods-Dr.Jonathan Zderad (University of Northwestern St.Paul)
