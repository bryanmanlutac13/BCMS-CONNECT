package Practicalexam;

import java.util.Scanner;

public class ArcadeCounterMenu {

    public void start(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\n==============================");
            System.out.println("       ARCADE COUNTER");
            System.out.println("==============================");
            System.out.println("1. Buy Tokens");
            System.out.println("2. Claim Prize");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
        }
        int choice = scanner.nextInt();

        if (choice == 1) {
        }
    }
}
