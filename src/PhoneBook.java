
import java.util.*;

public class PhoneBook {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void Menu(){
	  System.out.println("Type your option..");
	  System.out.println("1. Insert");
	  System.out.println("2. Edit");
	  System.out.println("3. Search");
	  System.out.println("4. Remove");
	  System.out.println("5. Print");
	  System.out.println("6. Quit");
	}
	 
	 public static void main(String arr[]){
		 CRUD pbdb = new CRUD();
		 
		 while(true){
		   Menu();
		   int input=keyboard.nextInt();
		   keyboard.nextLine();
		  
		   switch(input){
		   case 1://insert
		     pbdb.insert();
		     break;
		   case 2://edit
			 System.out.println("Type name to edit :");
			 String name1 = keyboard.nextLine();
			 pbdb.edit(name1);
			 break;
		   case 3://Search
			 System.out.println("Type name to search :");
			 String name2 = keyboard.nextLine();
			 System.out.println("Type job : ");
			 String job = keyboard.nextLine();
		     if(pbdb.search(name2, job)==-1) {
		    	 System.out.println("Cannot find the details");
		     }else {
		    	 
		     }
		     break;
		   case 4://remove
			 System.out.print("Type name to remove :");
			 String name = keyboard.nextLine();
		     pbdb.remove(name);
		     break;
		   case 5://print
			 pbdb.print();
			 break;  
		   case 6: System.out.println("Goodbye.");
		     return;
		   }
		  }//while
	 }//main
}

