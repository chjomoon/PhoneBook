
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Information;

public class Test {
	
	static Scanner keyboard = new Scanner(System.in);
	private static Person person;
	
	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction transaction;
	
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
	
    private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}//getRandomNumberInRange
	
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
		 
		 emf = Persistence.createEntityManagerFactory("PhoneBook");
		 em = emf.createEntityManager();

		 while(true){
		   menu();
		   int input=keyboard.nextInt();
		   keyboard.nextLine();
		  
		   switch(input){
		   case 1://insert
			 
		     //person.insert(jobInfo);
		     try {
		    	 String jobInfo = whichJob();
				 transaction = em.getTransaction();
				 transaction.begin();
		    	 int idNum = getRandomNumberInRange(1000,9999);
		    	 model.Information info = new model.Information();
		    	 if(jobInfo.equalsIgnoreCase("Student")) {
		    		 System.out.println("Type your School attending : ");
			 		 String school = keyboard.nextLine();
			 		 System.out.println("Type your Grades : ");
			 		 String grades = keyboard.nextLine();
		    		 info.setSchool(school);
		    		 info.setGrades(grades);
		    	 }else if(jobInfo.equalsIgnoreCase("Employee")) {
		    		 System.out.println("Type your Company : ");
			 		 String company = keyboard.nextLine();
			 		 System.out.println("Type your Salary : ");
			 		 String salary = keyboard.nextLine();
		    		 info.setCompany(company);
		    		 info.setSalary(salary);
		    	 }
		    	 System.out.println("Type your name : ");
 				 String name = keyboard.nextLine();
		 		 System.out.println("Type your Address : ");
		 		 String addr = keyboard.nextLine();
		 		 System.out.println("Type your phone Number: ");
		 		 int phone = keyboard.nextInt();
		    	 info.setJob(jobInfo);
		    	 info.setId(idNum);
		    	 info.setName(name);
		    	 info.setAddr(addr);
		    	 info.setPhone(phone);
		    	 
		    	 em.persist(info);
		    	 transaction.commit();
		     }catch(Throwable e) {
		    	 if (transaction.isActive()) {
		    		 transaction.rollback();
	    		 }
	    		 e.printStackTrace();
		     }
		     break;
		   case 2://edit
			 System.out.println("Type id to find :");
			 int findID = keyboard.nextInt();
			 keyboard.nextLine();
			 try {
				 model.Information user = em.find(model.Information.class, findID);
				 if(user != null) {
					 System.out.println("We find the person : "+ user.getName());
					 String jobInfo = whichJob();
					 transaction = em.getTransaction();
					 transaction.begin();
					 if(jobInfo.equalsIgnoreCase("Student")) {
			    		 System.out.println("Type your School attending : ");
				 		 String school = keyboard.nextLine();
				 		 System.out.println("Type your Grades : ");
				 		 String grades = keyboard.nextLine();
				 		user.setSchool(school);
				 		user.setGrades(grades);
			    	 }else if(jobInfo.equalsIgnoreCase("Employee")) {
			    		 System.out.println("Type your Company : ");
				 		 String company = keyboard.nextLine();
				 		 System.out.println("Type your Salary : ");
				 		 String salary = keyboard.nextLine();
				 		user.setCompany(company);
				 		user.setSalary(salary);
			    	 }
			    	 System.out.println("Type your name : ");
	 				 String name = keyboard.nextLine();
			 		 System.out.println("Type your Address : ");
			 		 String addr = keyboard.nextLine();
			 		 System.out.println("Type your phone Number: ");
			 		 int phone = keyboard.nextInt();
			 		user.setJob(jobInfo);
			 		user.setName(name);
			 		user.setAddr(addr);
			 		user.setPhone(phone);
			    	 
			    	 em.persist(user);
			    	 transaction.commit();
				 }else {
					System.out.println("Search failed");
					break;
				 }
			 }catch(Throwable e) {
				 if (transaction.isActive()) {
		    		 transaction.rollback();
	    		 }
				 System.out.println("Cannot find the information");
			 }
			 break;
		   case 3://Search
			 System.out.println("Type id to search :");
			 int idSearch = keyboard.nextInt();
			 keyboard.nextLine();
			 try {
				 model.Information user = em.find(model.Information.class, idSearch);
				 System.out.println("Name : " + user.getName() + "\nJob: "+ user.getJob() + "\nPhone: "+user.getJob());
			 }catch(Throwable e) {
				 if (transaction.isActive()) {
		    		 transaction.rollback();
	    		 }
				 System.out.println("Cannot find the information");
			 }
			 break;
		   case 4://remove
			 System.out.print("Type name to remove :");
			 int idRemove = keyboard.nextInt();
			 keyboard.nextLine();
			 try {
				 model.Information user = em.find(model.Information.class, idRemove);
				 System.out.println("We find the person : "+ user.getName());
				 while(true) {
					 System.out.println("Do you want to delete? (Y|N)");
					 String answer = keyboard.nextLine();
					 if(answer.equalsIgnoreCase("Y")) {
						 em.remove(user);
						 System.out.println("Removed successfully");
						 break;
					 }else if(answer.equalsIgnoreCase("N")) {
						 System.out.println("Remove Canceled");
						 break;
					 }else {
						 System.out.println("Wrong answer");
					 }
				 }
			 }catch(Throwable e) {
				 if (transaction.isActive()) {
		    		 transaction.rollback();
	    		 }
	    		 e.printStackTrace();
			 }
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


