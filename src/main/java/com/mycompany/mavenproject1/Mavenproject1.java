package com.mycompany.mavenproject1;
import java.util.Scanner;

public class Mavenproject1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login userLogin = new Login();

        System.out.println("=== Registration ===");
        System.out.print("Enter First Name: ");
        userLogin.setFirstName(input.nextLine());

        System.out.print("Enter Last Name: ");
        userLogin.setLastName(input.nextLine());

        System.out.print("Enter Username: ");
        userLogin.setUsername(input.nextLine());

        System.out.print("Enter Password: ");
        userLogin.setPassword(input.nextLine());

        System.out.print("Enter Cell Phone Number (+27...): ");
        userLogin.setCellPhoneNumber(input.nextLine());

        // Process Registration
        String registrationMessage = userLogin.registerUser();
        System.out.println(registrationMessage);

        // Only proceed to login if registration succeeded
        if (registrationMessage.equals("Username and password successfully captured.")) {
            System.out.println("\n=== Login ===");
            System.out.print("Enter username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter password: ");
            String loginPass = input.nextLine();

            boolean loggedIn = userLogin.loginUser(loginUser, loginPass);
            System.out.println(userLogin.returnLoginStatus(loggedIn));
        }

        input.close();
    }
}
