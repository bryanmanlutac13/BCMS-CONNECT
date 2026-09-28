package minipeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Manlutac_Login {

    @Test
    public void testLogin() {

        /*
         * Simulated user input
         *
         * 1 = Enter Username
         * 2 = Enter Password
         * 3 = Login
         * 4 = Exit
         */

        StringBuilder simulatedUserInput = new StringBuilder();

        simulatedUserInput.append("1\n"); // Enter Username
        simulatedUserInput.append("admin\n");

        simulatedUserInput.append("2\n"); // Enter Password
        simulatedUserInput.append("12345\n");

        simulatedUserInput.append("3\n"); // Login
        simulatedUserInput.append("4\n"); // Exit

        // Convert simulated input into a Scanner
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedUserInput.toString().getBytes());

        Scanner scanner = new Scanner(inputStream);

        boolean running = true;
        boolean loggedIn = false;

        String username = "";
        String password = "";

        // Correct login credentials
        String correctUsername = "admin";
        String correctPassword = "12345";

        System.out.println("=================================");
        System.out.println("            LOGIN SYSTEM");
        System.out.println("=================================");
        System.out.println();

        while (running && scanner.hasNextLine()) {

            System.out.println("---------------------------------");
            System.out.println("1. Enter Username");
            System.out.println("2. Enter Password");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            System.out.println("---------------------------------");

            int choice = Integer.parseInt(scanner.nextLine());

            System.out.println();
            System.out.print("> Selected option: ");
            System.out.println(choice);
            System.out.println();

            switch (choice) {

                case 1:
                    // Enter Username
                    System.out.println("Enter username:");

                    if (scanner.hasNextLine()) {
                        username = scanner.nextLine();

                        System.out.println();
                        System.out.print("> Username entered: ");
                        System.out.println(username);
                        System.out.println("Username saved successfully.");
                    }
                    break;

                case 2:
                    // Enter Password
                    System.out.println("Enter password:");

                    if (scanner.hasNextLine()) {
                        password = scanner.nextLine();

                        System.out.println();
                        System.out.println("> Password entered successfully.");
                        System.out.println("Password saved successfully.");
                    }
                    break;

                case 3:
                    // Login
                    if (username.isEmpty() || password.isEmpty()) {

                        System.out.println(
                                "ERROR: Please enter username and password first.");

                    } else if (username.equals(correctUsername)
                            && password.equals(correctPassword)) {

                        loggedIn = true;

                        System.out.println("Logging in...");
                        System.out.println("LOGIN SUCCESSFUL.");
                        System.out.println("Welcome, " + username + "!");
                    } else {

                        System.out.println(
                                "ERROR: Invalid username or password.");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting Login System.");
                    running = false;
                    break;

                default:
                    // Invalid choice
                    System.out.println(
                            "Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();

        // Simple test verification
        assert loggedIn : "User should be logged in.";

        System.out.println();
        System.out.println("=================================");
        System.out.println("         TEST COMPLETED");
        System.out.println("=================================");
    }
}