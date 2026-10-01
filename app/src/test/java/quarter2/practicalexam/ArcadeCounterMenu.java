package quarter2.practicalexam;

import java.util.Scanner;

public class ArcadeCounterMenu {

    static int counter = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("=== WELCOME TO ARCADE ===");

        while (running) {

            showMenu();

            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    addCounter(input);
                    break;

                case 2:
                    useCounter(input);
                    break;

                case 3:
                    checkCounter();
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for playing!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }

    public static void showMenu() {

        System.out.println();
        System.out.println("=== ARCADE COUNTER ===");
        System.out.println("1. Add Counter");
        System.out.println("2. Use Counter");
        System.out.println("3. Check Counter");
        System.out.println("4. Exit");
    }

    public static void addCounter(Scanner input) {

        System.out.print("Enter counters to add: ");
        int amount = input.nextInt();

        if (amount > 0) {

            counter += amount;

            System.out.println("Counter successfully added!");
            System.out.println("Current counter: " + counter);

        } else {

            System.out.println("Invalid amount.");
        }
    }

    public static void useCounter(Scanner input) {

        System.out.print("Enter counters to use: ");
        int amount = input.nextInt();

        if (amount <= 0) {

            System.out.println("Invalid amount.");

        } else if (amount > counter) {

            System.out.println("Not enough counter.");

        } else {

            counter -= amount;

            System.out.println("Counter successfully used!");
            System.out.println("Remaining counter: " + counter);
        }
    }

    public static void checkCounter() {

        System.out.println("Current counter: " + counter);
    }

}