package Time_Logger_Classes;
import java.sql.*;
import java.util.*;

public class Task_Category{
	private long Task_CatID;
	private String Task_Category, inMessage,Category_Description;
	
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
	
	public String Messenger(String inMessage, String category, String Category_Description) {
		this.inMessage = inMessage;
		this.Task_Category= category;
		this.Category_Description=Category_Description;
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
	
	static public String[]CategoryInfo(){
		Map<Integer,String> TransferMap= new HashMap<Integer,String>();
		int count=0;
	try {
		Connection con=DB_Connectivity.DB_Connector();
		String query="SELECT DISTINCT Task_Category, Category_Description FROM task_category ORDER BY Task_Category ";		
		Statement stmnt=con.createStatement();
		ResultSet rslt=stmnt.executeQuery(query);
		int count2=0;
		while(rslt.next()) {
		String TaskCat=rslt.getString(1);
		String CatDesc=rslt.getString(2);
		String CatInfo=TaskCat+": "+CatDesc;
		System.out.println(CatInfo);
		TransferMap.put(count2,CatInfo);
		System.out.println(TransferMap);
		count++;
		count2++;
		}
	}
	catch(Exception e) {
		System.out.println("Exception thrown trying to retrieve Task Category and Task Description.");
	}
	String[]CatInfoArr=new String[count];
	System.out.println(TransferMap);
	for(int r=0;r<TransferMap.size();r++) {
		String TransferString=TransferMap.get(r);
		CatInfoArr[r]=TransferString;
	}
	for(int r=0;r<CatInfoArr.length;r++) {
	}
	return CatInfoArr;
	}
	public void Insert() {
		try {
		Connection con=DB_Connectivity.DB_Connector();	
		//The question marks are parameters you can fill with variables
		String query="INSERT INTO task_category(Task_Category,Category_Description) VALUES (?,?)";
		//This allows for queries(beyond just selecting) to be executed in the code
		PreparedStatement pstmnt=con.prepareStatement(query);
		//these statements set the parameters with the numbers preceding the attributes designating their position
		//in the query
		pstmnt.setString(1,this.Task_Category);
		pstmnt.setString(2,this.Category_Description);
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
