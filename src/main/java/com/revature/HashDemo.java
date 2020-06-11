package com.revature;

import java.util.HashSet;

public class HashDemo {
	public static void main(String[] args) {
		HashSet<VeryBrokenHashUser> users = new HashSet<>();
		
		users.add(new VeryBrokenHashUser("Abby"));
		users.add(new VeryBrokenHashUser("Billy"));
		users.add(new VeryBrokenHashUser("Cindy"));
		users.add(new VeryBrokenHashUser("Abby"));
		users.add(new VeryBrokenHashUser("Danny"));
		
		System.out.println(users);
	}
}

class GoodHashUser {
	String username;

	public GoodHashUser(String username) {
		super();
		this.username = username;
	}



	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		System.out.println("Calculating hashcode for " + username + ", value: " + result);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		System.out.println("Checking for equality between " + this + " and " + obj);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodHashUser other = (GoodHashUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "GoodHashUser [username=" + username + "]";
	}	
}


class BrokenHashUser {
	String username;

	@Override
	public int hashCode() {
		System.out.println("Calculating hashcode for " + username + ", value: " + 1);
		return 1;
	}
	
	
	
	public BrokenHashUser(String username) {
		super();
		this.username = username;
	}



	@Override
	public boolean equals(Object obj) {
		System.out.println("Checking equality between " + this + " and " + obj);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BrokenHashUser other = (BrokenHashUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "BrokenHashUser [username=" + username + "]";
	}	
}

class VeryBrokenHashUser {
	String username;

	@Override
	public int hashCode() {
		
		int result = (int) Math.floor(Math.random() * 1000);
		System.out.println("Calculating hashcode for " + username + ", value: " + result);
		return result;
	}
	
	
	
	public VeryBrokenHashUser(String username) {
		super();
		this.username = username;
	}



	@Override
	public boolean equals(Object obj) {
		System.out.println("Checking equality between " + this + " and " + obj);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BrokenHashUser other = (BrokenHashUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "VeryBrokenHashUser [username=" + username + "]";
	}	
}