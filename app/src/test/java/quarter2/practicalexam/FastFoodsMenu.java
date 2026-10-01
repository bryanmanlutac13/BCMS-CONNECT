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
        }
    }
}