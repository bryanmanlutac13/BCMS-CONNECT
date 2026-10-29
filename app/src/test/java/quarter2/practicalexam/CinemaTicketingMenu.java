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

            System.out.println();
        }
    }
}