package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the information database table.
 * 
 */
@Entity
@NamedQuery(name="Information.findAll", query="SELECT i FROM Information i")
public class Information implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String addr;

	private String company;

	private String grades;

	private String job;

	private String name;

	private int phone;

	private String salary;

	private String school;

	public Information() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGrades() {
		return this.grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}