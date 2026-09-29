package quarter2.practicalexam;

import java.util.Scanner;

public class PCCafeMenu {

    // ================================
    // MAIN MENU
    // ================================
    public void run(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("================================");
            System.out.println("        PC CAFE SYSTEM");
            System.out.println("================================");
            System.out.println();
            System.out.println("1. Register");
            System.out.println("2. PC Café E-Wallet");
            System.out.println("3. Buy PC Hours");
            System.out.println("4. Food and Drinks");
            System.out.println("5. Login to PC");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            // Show simulated/user input
            System.out.println(option);

            switch (option) {

                case 1:
                    new Register().runFeature(scanner);
                    break;

                case 2:
                    new EWallet().runFeature(scanner);
                    break;

                case 3:
                    new PCHours().runFeature(scanner);
                    break;

                case 4:
                    new FoodAndDrinks().runFeature(scanner);
                    break;

                case 5:
                    new PCLogin().runFeature(scanner);
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Thank you for using PC Café!");
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================
    // 1. REGISTER
    // =========================================================
    class Register {

        public void runFeature(Scanner scanner) {

        }
    }

    // =========================================================
    // 2. E-WALLET
    // =========================================================
    class EWallet {

        public void runFeature(Scanner scanner) {

        }
    }

    // =========================================================
    // 3. BUY PC HOURS
    // =========================================================
    class PCHours {

        public void runFeature(Scanner scanner) {

        }
    }

    // =========================================================
    // 4. FOOD AND DRINKS
    // =========================================================
    class FoodAndDrinks {

        public void runFeature(Scanner scanner) {

        }
    }

    // =========================================================
    // 5. LOGIN TO PC
    // =========================================================
    class PCLogin {

        public void runFeature(Scanner scanner) {

        }
    }

    // =========================================================
    // PC SESSION
    // =========================================================
    class PCSession {

        public void runFeature() {

        }
    }
}