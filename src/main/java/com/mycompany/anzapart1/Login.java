package com.mycompany.anzapart1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
 public Login(String Uname, String passW, String fName, String lName) {
        username = Uname;
        password = passW;
        firstName = fName;
        lastName = lName;
    }


    public boolean checkUserName() {
        boolean condition = username.contains("_") && username.length() <= 5;
        return condition;
    }

   
    public boolean checkPasswordComplexity() {
        if (password.length() <= 7) {
            return false;
        }

        boolean containsUppercase = false;
        boolean containsNumber  = false;
        boolean containsSpecialCharacter  = false;

     for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (Character.isUpperCase(character)) {
                containsUppercase = true;
            }
            if (Character.isDigit(character)) {
                containsNumber = true;
            }
            if (!Character.isLetterOrDigit(character)) {
                containsSpecialCharacter = true;
            }
        }
        return containsUppercase && containsNumber && containsSpecialCharacter;
    }

 
 public String registerUser() {
    String message;

    if (checkUserName()) {
        System.out.println("Username successfully captured");

        if (checkPasswordComplexity()) {
            System.out.println("Password successfully captured");
            message = "The user has been registered successfully";
        } else {
            message = "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
    } else {
        message = "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
    }

    return message;
}

   
    public boolean loginUser(String Username, String Password) {
    if (username.equals(Username)) {
        if (password.equals(Password)) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

  
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect";
        }
    }
}