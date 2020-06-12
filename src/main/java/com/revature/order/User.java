package com.revature.order;

import java.time.LocalDate;


/**
 * Common code generation for models:
 * * Getters/Setters
 * * hashcode/equals
 * * toString
 * * Constructor with parameters
 * * no args constructor (from super)
 * 
 * Order - Order defines an expression that defines whether two objects are in order relative to
 * one another.  When all items in a collection are ordered, then they are sorted.
 * 
 * 
 * Natural Order - Natural order is the 'default' ordering for an object.  This can be considered
 * to be the assumed order. Natural order is defined by implementing an interface on the class
 * that is to be ordered. This interface is called Comparable
 * 
 */
public class User implements Comparable<User> {
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate lastLogin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", lastLogin=" + lastLogin
				+ "]";
	}

	public User(int id, String firstName, String lastName, LocalDate lastLogin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLogin = lastLogin;
	}

	public User() {
		super();
	}

	@Override
	public int compareTo(User o) {
		return this.id - o.id;
	}
}
