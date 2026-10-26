package com.securelogin;

import java.util.HashMap;

public class UserServiceClass {
	
	    private HashMap<String, String> users = new HashMap<>();

	
	    public boolean register(String username, String password) {

	        if (!PasswordUtilClass.isValidPassword(password)) {
	            System.out.println("Password must contain at least 8 characters, uppercase, lowercase, and digit.");
	            return false;
	        }

	        if (users.containsKey(username)) {
	            System.out.println("User already exists!");
	            return false;
	        }

	        users.put(username, password);
	        System.out.println("Registration successful!");
	        return true;
	    }

	  
	    public boolean login(String username, String password) {

	        if (!users.containsKey(username)) {
	            System.out.println("User not found!");
	            return false;
	        }

	        if (users.get(username).equals(password)) {
	            System.out.println("Login successful!");
	            return true;
	        } else {
	            System.out.println("Invalid password!");
	            return false;
	        }
	    }
	
}
