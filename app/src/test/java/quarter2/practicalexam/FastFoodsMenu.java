package quarter2.practicalexam;

import java.util.Scanner;

public class FastFoodsMenu {

    public void start(Scanner scanner) {
        int choice = 0;

        // Repeat until the user chooses Exit
        while (choice != 3) {
            System.out.println("===== FAST FOOD MENU =====");
            System.out.println("1. Order Burger");
            System.out.println("2. Order Fries");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("You selected Order Burger.");

            } else if (choice == 2) {
                System.out.println("You selected Order Fries.");

            } else if (choice == 3) {
                System.out.println("Thank you for ordering!");

            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}