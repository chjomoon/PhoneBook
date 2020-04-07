import java.sql.*;
import java.util.Random;


public class PersonDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	//Statement stmt = null;

	//public ArrayList<Books> goodsList = null;
	public PersonDAO(){
	        try{
	            String dbURL = "jdbc:mysql://localhost/phonebook?&useSSL=false";
	            String dbID = "root";
	            String dbPassword = "1212";
	            
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
	            System.out.println("Connected");
	        }catch(Exception e){
	        	System.out.println("No Connection");
	            e.printStackTrace();
	        }
    }

	public String print() {
		String SQL = "SELECT * FROM information";
		try {
			 pstmt = conn.prepareStatement(SQL);
			 //STEP 5: Extract data from result set
			 rs = pstmt.executeQuery();
		      while(rs.next()){
		         //Retrieve by column name
		    	 int id  = rs.getInt("id");
		         String job = rs.getString("job");
		         String name = rs.getString("name");
		         int phone = rs.getInt("phone");
		         String addr = rs.getString("addr");
		         String school = rs.getString("school");
		         String grades = rs.getString("grades");
		         String company = rs.getString("company");
		         String salary = rs.getString("salary");
		         
		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Job: " + job);
		         System.out.print(", Name: " + name);
		         System.out.print(", Phone: " + phone);
		         System.out.print(", Address: " + addr);
		         if(job.equalsIgnoreCase("student")) {
			         System.out.print(", Attending School: " + school);
			         System.out.println(", Grades: " + grades);

		         }else if(job.equalsIgnoreCase("employee")) {
		        	 System.out.print(", Working Company: " + company);
			         System.out.println(", Salary: " + salary);
		         }else {
		        	 System.out.println("\n");
		         }
		      }//while
		      return "Print Success";
		}catch(Exception e){
            e.printStackTrace();
        }//try-catch
		return "Print Fail";
	}//test  
    
    public int create(Person person){
    	int idGenerator = getRandomNumberInRange(1000,9999);
    	
        String SQL ="INSERT INTO information VALUES(?, ?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,idGenerator);
            pstmt.setString(2,person.getJob());
            pstmt.setString(3,person.getName());
            pstmt.setString(4,person.getPhone());
            pstmt.setString(5,person.getAddr());

            System.out.println(idGenerator);
            System.out.println("Signup Person: "+person.getName());

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;//db error
    }

    public int create(Student student){
    	int idGenerator = getRandomNumberInRange(1000,9999);
    	
        String SQL ="INSERT INTO information VALUES(?, ?, ?, ?, ?,?,?)";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,idGenerator);
            pstmt.setString(2,student.getJob());
            pstmt.setString(3,student.getName());
            pstmt.setString(4,student.getPhone());
            pstmt.setString(5,student.getAddr());
            pstmt.setString(6,student.getSchool());
            pstmt.setString(7,student.getGrades());

            System.out.println(idGenerator);
            System.out.println("Signup Student: "+student.getName());

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;//db error
    }
    
    public int create(Employee employee){
    	int idGenerator = getRandomNumberInRange(1000,9999);
    	
        String SQL ="INSERT INTO information VALUES(?, ?, ?, ?, ?,?,?,?,?)";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,idGenerator);
            pstmt.setString(2,employee.getJob());
            pstmt.setString(3,employee.getName());
            pstmt.setString(4,employee.getPhone());
            pstmt.setString(5,employee.getAddr());
            pstmt.setString(6,null);
            pstmt.setString(7,null);
            pstmt.setString(8,employee.getCompany());
            pstmt.setInt(9,employee.getSalary());
            System.out.println(idGenerator);
            System.out.println("Signup Employee: "+employee.getName());

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;//db error
    }
    
    public int read(String name) {
    	String SQL ="select * from information WHERE name =?";
    	try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()){
	        	 int id  = rs.getInt("id");
		         String job = rs.getString("job");
		         int phone = rs.getInt("phone");
		         String addr = rs.getString("addr");
		         String school = rs.getString("school");
		         String grades = rs.getString("grades");
		         String company = rs.getString("company");
		         String salary = rs.getString("salary");
		       //Display values
		         System.out.println("We found the detail below : ");
		         System.out.print("ID: " + id);
		         System.out.print(", Job: " + job);
		         System.out.print(", Name: " + name);
		         System.out.print(", Phone: " + phone);
		         System.out.print(", Address: " + addr);
		         if(job.equalsIgnoreCase("student")) {
			         System.out.print(", Attending School: " + school);
			         System.out.println(", Grades: " + grades);

		         }else if(job.equalsIgnoreCase("employee")) {
		        	 System.out.print(", Working Company: " + company);
			         System.out.println(", Salary: " + salary);
		         }else {
		        	 System.out.println("\n");
		         }
            	return 1;
            }
    	}catch(Exception e){
            e.printStackTrace();
        }
    	return -1;
    }    
    
    public int update(Person person, String name) {
    	String SQL = "UPDATE information SET job=?, phone=?, addr=? WHERE name=?";
        try {
            pstmt = conn.prepareStatement(SQL);
        	pstmt.setString(1, person.getJob());
        	pstmt.setString(2, person.getPhone());
            pstmt.setString(3, person.getAddr());
            pstmt.setString(4,person.getName());
            
            return pstmt.executeUpdate();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; //db error
    }
    
    public int update(Student stud, String name) {
    	String SQL = "UPDATE information SET job=?, phone=?, addr=?, school=?,grades=? WHERE name=?";
        try {
            pstmt = conn.prepareStatement(SQL);
        	pstmt.setString(1, stud.getJob());
        	pstmt.setString(2, stud.getPhone());
            pstmt.setString(3, stud.getAddr());
            pstmt.setString(4, stud.getSchool());
            pstmt.setString(5, stud.getGrades());
            pstmt.setString(6,stud.getName());
            
            return pstmt.executeUpdate();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; //db error
    }
    
    public int update(Employee employee, String name) {
    	String SQL = "UPDATE information SET job=?, phone=?, addr=?, company=?,salary=? WHERE name=?";
        try {
            pstmt = conn.prepareStatement(SQL);
        	pstmt.setString(1, employee.getJob());
        	pstmt.setString(2, employee.getPhone());
            pstmt.setString(3, employee.getAddr());
            pstmt.setString(4, employee.getCompany());
            pstmt.setInt(5, employee.getSalary());
            pstmt.setString(6,employee.getName());
            
            return pstmt.executeUpdate();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; //db error
    }
    
    public int delete(String name) {
    	String SQL = "DELETE FROM information WHERE name =?";
    	try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, name);
            return pstmt.executeUpdate();
    	}catch (Exception e){
            e.printStackTrace();
        }
    	return -1;//db error
    }
    
    
    private int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}//getRandomNumberInRange
    
}//PersonDAO
