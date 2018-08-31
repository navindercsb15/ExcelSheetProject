package controller;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="dept_id")
	private int id;
	
	@Column(name="dept_name")
	private String name;
	
	@Column(name="dept_location")
	private String location;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dept")
	private Set<Employee> employees;
	
	public Department(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}	
}
