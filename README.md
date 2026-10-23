

public class UserClass {
	
	    private String username;
	    private String password;

	    public void User(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }
	
}
package com.securelogin;

public class PasswordUtilClass {
	

	    public static boolean isValidPassword(String password) {
	       
	        if (password.length() < 8) return false;

	        boolean hasUpper = false;
	        boolean hasLower = false;
	        boolean hasDigit = false;

	        for (char ch : password.toCharArray()) {
	            if (Character.isUpperCase(ch)) hasUpper = true;
	            else if (Character.isLowerCase(ch)) hasLower = true;
	            else if (Character.isDigit(ch)) hasDigit = true;
	        }

	        return hasUpper && hasLower && hasDigit;
	    }
	
}
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
package com.securelogin;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserServiceClass service = new UserServiceClass();

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter username: ");
                    String regUser = sc.nextLine();

                    System.out.print("Enter password: ");
                    String regPass = sc.nextLine();

                    service.register(regUser, regPass);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String logUser = sc.nextLine();

                    System.out.print("Enter password: ");
                    String logPass = sc.nextLine();

                    service.login(logUser, logPass);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
} 
