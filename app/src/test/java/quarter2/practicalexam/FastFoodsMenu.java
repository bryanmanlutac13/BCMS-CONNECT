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

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n===== BURGER OPTIONS =====");
                System.out.println("1. Combo");
                System.out.println("2. Solo");
                System.out.print("Choose burger option: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid burger option.");
                    scanner.nextLine();
                    continue;
                }

                int burgerChoice = scanner.nextInt();

                if (burgerChoice == 1) {
                    System.out.println("You ordered a Burger Combo.");
                    System.out.println("Order confirmed!");

                } else if (burgerChoice == 2) {
                    System.out.println("You ordered a Solo Burger.");
                    System.out.println("Order confirmed!");

                } else {
                    System.out.println("Invalid burger option.");
                }

            } else if (choice == 2) {
                System.out.println("You ordered Fries.");
                System.out.println("Order confirmed!");

            } else if (choice == 3) {
                System.out.println("Thank you for ordering!");
                System.out.println("Exiting Fast Food System...");

            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}