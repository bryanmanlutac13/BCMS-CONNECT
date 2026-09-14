package MiniPeta3;

import org.junit.Test;

import java.util.Scanner;

public class Caringal_MiniPeta1 {

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String correctUsername = "mirande";
        String correctPassword = "0123456";

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Login successful!");
            System.out.println("Welcome to BCMS Connect!");
        } else {
            System.out.println("Invalid username or password.");
        }

        input.close();
    }