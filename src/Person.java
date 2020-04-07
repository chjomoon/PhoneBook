public class Person {
	private String job;
	private String name;
	private String phone;
	private String addr;		 
	
	
	public Person(String job, String name, String phone, String addr) {
		this.job = job;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		
	}
	public void showInfo(){
		 System.out.println("Job : " + getJob() + "Name : " +getName() +"\nPhone :" + getPhone()
				 	+ "\nAddr: "+getAddr());
		 System.out.println();
	 	} 
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

	public Student(String job, String name, String phone,  String addr, String school, String grades) {
		super(job, name, phone, addr);
		this.school = school;
		this.grades = grades;
		// TODO Auto-generated constructor stub
	}
	
	public void showInfo(){
		System.out.println("Job : " + getJob() + "\nName : " +getName() +"\nPhone :" + getPhone()
			 	+ "\nAddr: "+getAddr() + "\nSchool : "+ getSchool() + "\nGrades : " + getGrades());
	 System.out.println();
	}
}//Student

class Employee extends Person{

	private String company;
	private int salary;
	
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

	public Employee(String job, String name, String phone, String addr, String company, int salary) {
		super(job, name, phone, addr);
		this.company = company;
		this.salary = salary;
		
		// TODO Auto-generated constructor stub
	}
	
	public void showInfo(){
		 System.out.println("Job : " + getJob() + "\nName : " +getName() +"\nPhone :" + getPhone()
				 	+ "\nAddr: "+getAddr() + "\nCompany : "+getCompany() + "\nSalary : " +  getSalary() );
		 System.out.println();
	 	} 
	
}//Employee