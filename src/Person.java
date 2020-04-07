import java.util.Scanner;

interface Job {
	public void insert(String job);
	public int search(String name);
	public void edit(String name, String job);
	public void remove(String name);	
}

public class Person  implements Job {
	private String job;
	private String name;
	private String phone;
	private String addr;		 
	PersonDAO dao;
	Scanner keyboard = new Scanner(System.in);
	
	public Person() {
		dao = new PersonDAO();
	}//person
	
	public Person(String job, String name, String phone, String addr) {
		this.job = job;
		this.name = name;
		this.phone = phone;
		this.addr = addr;	
		
	}//person
	
	public void insert(String job) {
			
		System.out.println("Type your name : ");
		String name = keyboard.nextLine();
		System.out.println("Type your phone Number: ");
		String phone = keyboard.nextLine();
		System.out.println("Type your Address : ");
		String addr = keyboard.nextLine();
		dao.create(new Person(job, name, phone, addr));
	}//insert
	
	
	public int search(String name){
		return dao.read(name);
	}//search
	
	public void edit(String name, String job) {
		
		System.out.println("Type your phone Number: ");
		String phone = keyboard.nextLine();
		System.out.println("Type your Address : ");
		String addr = keyboard.nextLine();
		dao.update(new Person(job,name,phone, addr), name);
		
	}//edit
	
	public void remove(String name) {		
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
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}

class Student extends Person{

	private String school;
	private String grades;
	
	
	public Student() {
		super();	
	}
	
	public Student(String job, String name, String phone,  String addr, String school, String grades) {
		super(job, name, phone, addr);
		this.school = school;
		this.grades = grades;
		// TODO Auto-generated constructor stub
	}
	public void insert(String job) {	
		System.out.println("Type your name : ");
		String name = keyboard.nextLine();
		System.out.println("Type your phone Number: ");
		String phone = keyboard.nextLine();
		System.out.println("Type your Address : ");
		String addr = keyboard.nextLine();
		System.out.println("Type your School : ");
		String school = keyboard.nextLine();
		System.out.println("Type your Grades : ");
		String grades = keyboard.nextLine();
		dao.create(new Student("Student", name, phone, addr,school,grades));
	}
	public void edit(String name, String job) {
		
		System.out.println("Type your phone Number: ");
		String phone = keyboard.nextLine();
		System.out.println("Type your Address : ");
		String addr = keyboard.nextLine();	
		System.out.println("Type your School : ");
		String school = keyboard.nextLine();
		System.out.println("Type your Grades : ");
		String grades = keyboard.nextLine();
		dao.update(new Student(job,name,phone,addr,school,grades), name);
		
	}
	
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}
	
	
}//Student

class Employee extends Person{

	private String company;
	private int salary;

	public Employee() {
		super();
	}
	
	public Employee(String job, String name, String phone, String addr, String company, int salary) {
		super(job, name, phone, addr);
		this.company = company;
		this.salary = salary;
		
		// TODO Auto-generated constructor stub
	}
	public void insert(String job) {	
		System.out.println("Type your name : ");
		String name = keyboard.nextLine();
		System.out.println("Type your phone Number: ");
		String phone = keyboard.nextLine();
		System.out.println("Type your Address : ");
		String addr = keyboard.nextLine();
		System.out.println("Type your Company : ");
		String company = keyboard.nextLine();
		System.out.println("Type your Salary : ");
		int salary = keyboard.nextInt();
		dao.create(new Employee("Employee", name, phone, addr,company,salary));
	}
	
	public void edit(String name, String job) {
		System.out.println("Type your phone Number: ");
		String phone = keyboard.nextLine();
		System.out.println("Type your Address : ");
		String addr = keyboard.nextLine();	
		System.out.println("Type your Company : ");
		String company = keyboard.nextLine();
		System.out.println("Type your Salary : ");
		int salary = keyboard.nextInt();
		dao.update(new Employee(job, name, phone, addr,company,salary), name);
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}//Employee