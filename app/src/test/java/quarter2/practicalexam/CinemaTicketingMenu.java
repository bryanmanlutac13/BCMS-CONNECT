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

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Buy Ticket selected.");

            } else if (choice == 2) {
                System.out.println("Buy Snacks selected.");

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