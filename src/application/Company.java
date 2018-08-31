package application;

public class Company {
	private String username;
	private String name;
	private String city;
	public Company(String username, String name, String city) {
		this.username = username;
		this.name = name;
		this.city = city;
	}
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
