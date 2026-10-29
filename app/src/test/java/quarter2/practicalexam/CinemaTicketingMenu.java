package quarter2.practicalexam;

import java.util.Scanner;

public class CinemaTicketingMenu {

    public void start(Scanner scanner) {
        int choice = 0;

        while (choice != 3) {
            System.out.println("===== CINEMA MENU =====");
            System.out.println("1. Buy Ticket");
            System.out.println("2. Buy Snacks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter your age: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid age.");
                    scanner.nextLine();
                    continue;
                }

                int age = scanner.nextInt();

                if (age >= 18) {
                    System.out.println("Access Granted.");
                    System.out.println("Ticket Printed!");
                } else {
                    System.out.println("Access Denied.");
                    System.out.println("You must be 18 or older.");
                }

            } else if (choice == 2) {
                System.out.println("Snacks purchased!");
                System.out.println("Enjoy your snacks!");

            } else if (choice == 3) {
                System.out.println("Thank you for visiting!");
                System.out.println("Exiting Cinema System...");

            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}