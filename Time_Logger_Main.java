package Time_Logger_Classes;
import java.util.*;

public class Time_Logger_Main  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Create scanner and the Init String to initialize new instance of class objects
		// in the respective messenger method
		Scanner ui=new Scanner(System.in);
		String Init="Init";
		
		System.out.print("Name the type of task:");
		String Task_Type= ui.nextLine();
		System.out.print("Give a description of the task:");
		String Description=ui.nextLine();
		Tasks Task= new Tasks();
		
		
		System.out.print("Enter the category:");
		String category= ui.nextLine();
		Task_Category TaskCat=new Task_Category();
		
		
		System.out.print("State the number of hours the task took(only whole hours because additional minutes will be dealt with next):");
		double Hours=ui.nextDouble();
		ui.nextLine();
		System.out.print("State the number of minutes the task took in addition to the number of hours:" );
		double Minutes=ui.nextDouble();
		ui.nextLine();
		Hours=Hours+(Minutes/60);
		System.out.print("State the start date of the task in this format YYYY-MM-DD:");
		String StartDate=ui.nextLine();
		System.out.print("State the end date of the task in this format YYYY-MM-DD:");
		String EndDate=ui.nextLine();
		System.out.print("State the start day of the week of the task:");
		String Start_Day_of_Week=ui.nextLine();
		System.out.print("State the end day of the week of the task:");
		String End_Day_of_Week=ui.nextLine();
		System.out.print("State the military time you started the task:");
		String StartTime=ui.nextLine();
		System.out.print("State the military time you ended the task:");
		String EndTime=ui.nextLine();
		Time_Transactions Transaction=new Time_Transactions();
		//This order of calling the messenger methods is key.
		//The Transaction class needs the task ID from the new task
		//and the newly created task needs the new Task_Category_ID.
		//Therefore it's necessary that the data must be added in this
		//order: Task_Category, Tasks, and finally Time_Transactions
		TaskCat.Messenger(Init, category);
		Task.Messenger(Init,Task_Type,Description);
		Transaction.Messenger(Init,StartDate,Start_Day_of_Week,End_Day_of_Week,EndDate,EndTime,StartTime,Hours);
	}
}