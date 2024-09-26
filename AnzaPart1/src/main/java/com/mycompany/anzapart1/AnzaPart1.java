/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.anzapart1;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class AnzaPart1 {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Register a new account:");

        String username = "";
        while (username.isEmpty()) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username cannot be blank. Please try again.");
            }
        }

        String password = "";
        while (password.isEmpty()) {
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
                System.out.println("Password cannot be blank. Please try again.");
            }
        }


        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

 
        Login login = new Login(username, password, firstName, lastName);

  
        String registrationResult = login.registerUser();
        System.out.println(registrationResult);

 
        if (registrationResult.equals("The user has been registered successfully")) {
            System.out.println("\nLogin to your account:");

      
            String loginUsername = "";
            while (loginUsername.isEmpty()) {
                System.out.print("Enter username: ");
                loginUsername = scanner.nextLine();
                if (loginUsername.isEmpty()) {
                    System.out.println("Username cannot be blank. Please try again.");
                }
            }

     
            String loginPassword = "";
            while (loginPassword.isEmpty()) {
                System.out.print("Enter password: ");
                loginPassword = scanner.nextLine();
                if (loginPassword.isEmpty()) {
                    System.out.println("Password cannot be blank. Please try again.");
                }
            }


            String loginStatus = login.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(loginStatus);
        }

        scanner.close();
    }
}
