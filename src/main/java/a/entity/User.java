package a.entity;

import java.io.Serializable;

public class User implements Serializable {

	private Integer id;
	private String username;
	private String password;
	private Double salary;

	/**
	 * 无参构造
	 */
	public User() {

	}

	/**
	 * 有参构造
	 */
	public User(Integer id, String username, String password, Double salary) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salary=" + salary + "]";
	}

}
