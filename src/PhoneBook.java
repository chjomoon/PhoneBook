
import java.util.*;

public class PhoneBook {
	
	static Scanner keyboard = new Scanner(System.in);
	private static Person person;
	
	
	public static String whichJob() {
		System.out.println("Type your Job : ");
		 String job = keyboard.nextLine();	
		 if(job.equalsIgnoreCase("student")) {
			 person = new Student();
			 return "Student";
		 }else if(job.equalsIgnoreCase("employee")) {
			 person = new Employee();
			 return "employee";
		 }else {
			 person = new Person();
			 return job;
		 }
	}
	
	public static void menu(){
	  System.out.println("Type your option..");
	  System.out.println("1. Insert");
	  System.out.println("2. Edit");
	  System.out.println("3. Search");
	  System.out.println("4. Remove");
	  System.out.println("5. Print");
	  System.out.println("6. Quit");
	}
	 
	 public static void main(String arr[]){
		 person = new Person();
		 while(true){
		   menu();
		   int input=keyboard.nextInt();
		   keyboard.nextLine();
		  
		   switch(input){
		   case 1://insert
			 String jobInfo = whichJob();
		     person.insert(jobInfo);
		     break;
		   case 2://edit
			 System.out.println("Type name to edit :");
			 String name = keyboard.nextLine();
			 if(person.search(name)==-1) {
		    	 System.out.println("Cannot find the details");
		     }else {
		    	 String job = whichJob();
				 person.edit(name, job);
		     }
			 
			 break;
		   case 3://Search
			 System.out.println("Type name to search :");
			 String nameSearch = keyboard.nextLine();
		     if(person.search(nameSearch)==-1) {
		    	 System.out.println("Cannot find the details");
		     }else {
		    	 
		     }
		     break;
		   case 4://remove
			 System.out.print("Type name to remove :");
			 String nameRemove = keyboard.nextLine();

		     person.remove(nameRemove);
		     break;
		   case 5://print
			 person.print();
			 break;  
		   case 6: System.out.println("Goodbye.");
		     return;
		   }
		  }//while
	 }//main
}


