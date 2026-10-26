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