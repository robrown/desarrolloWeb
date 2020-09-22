package model;

public class User {
	int id;
	
	String user_name;
	String password;
	String name;
	String last_name_one;
	String last_name_two;
	String dni;
	
	public User(String user_name, String name, String last_name_one, String last_name_two, String dni, String pass) {
		super();
		this.user_name = user_name;
		this.name = name;
		this.last_name_one = last_name_one;
		this.last_name_two = last_name_two;
		this.dni = dni;
		this.password = pass;
	}
	
	public User() {
		super();
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name_one() {
		return last_name_one;
	}
	public void setLast_name_one(String last_name_one) {
		this.last_name_one = last_name_one;
	}
	public String getLast_name_two() {
		return last_name_two;
	}
	public void setLast_name_two(String last_name_two) {
		this.last_name_two = last_name_two;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
