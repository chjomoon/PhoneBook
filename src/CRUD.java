import java.util.Scanner;

public class CRUD{

	PersonDAO dao;
	Scanner keyboard = new Scanner(System.in);

	public CRUD(){
		dao = new PersonDAO();
	}
	
	void insert() {
		System.out.println("Type your Job : ");
		String job = keyboard.nextLine();
		
		System.out.println("");
		System.out.println("Type your name : ");
		String name = keyboard.nextLine();
		System.out.println("Type your phone Number: ");
		String phone = keyboard.nextLine();
		System.out.println("Type your Address : ");
		String addr = keyboard.nextLine();
		if(job.equalsIgnoreCase("Student")) {
			System.out.println("Type your School : ");
			String school = keyboard.nextLine();
			System.out.println("Type your Grades : ");
			String grades = keyboard.nextLine();
			dao.create(new Student(job, name, phone, addr,school,grades));

		}else if(job.equalsIgnoreCase("employee")) {
			System.out.println("Type your Company : ");
			String company = keyboard.nextLine();
			System.out.println("Type your Salary : ");
			int salary = keyboard.nextInt();
			dao.create(new Employee(job, name, phone, addr,company,salary));
		}else
			dao.create(new Person(job, name, phone, addr));
		}//insert

	
	void edit(String name) {
		int i = dao.read(name);
		if(i == -1) {
			System.out.println("Cannot find the information");
		}else {
			System.out.println("Type your Job : ");
			String job = keyboard.nextLine();
			System.out.println("Type your phone Number: ");
			String phone = keyboard.nextLine();
			System.out.println("Type your Address : ");
			String addr = keyboard.nextLine();
			
			if(job.equalsIgnoreCase("Student")) {
				System.out.println("Type your School : ");
				String school = keyboard.nextLine();
				System.out.println("Type your Grades : ");
				String grades = keyboard.nextLine();
				dao.update(new Student(job,name,phone,addr,school,grades), name);
			}else if(job.equalsIgnoreCase("employee")) {
				System.out.println("Type your Company : ");
				String company = keyboard.nextLine();
				System.out.println("Type your Salary : ");
				int salary = keyboard.nextInt();
				dao.update(new Employee(job, name, phone, addr,company,salary), name);
			}else {
				dao.update(new Person(job,name,phone, addr), name);
			}
		}

	}
/*	
	public int search(String name){ 
	  for(int i = 0; i<count; i++){
		  if(name.compareTo(phoneBook[i].getName()) == 0){
			  return i;
		  }//if
	  	}//for
	  	return -1;
	}//search
*/	
	
	public int search(String name, String job){
		return dao.read(name);
	}//search
	
	void remove(String name) {
		
		int result = dao.delete(name);
		if (result == -1) {
			System.out.println("fail");
		}else {
			System.out.println("DB removed");
		}

	}//remove
	
	void print() {
		dao.print();
	}//print
	
}