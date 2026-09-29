package quarter2.practicalexam;

import java.util.Scanner;

public class PCCafeMenu {

    // ================================
    // ACCOUNT DATA
    // ================================
    private String username = "";
    private String password = "";

    private double walletBalance = 0.00;
    private int pcMinutes = 0;

    private boolean registered = false;

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

            System.out.println();
            System.out.println("================================");
            System.out.println("          REGISTER");
            System.out.println("================================");
            System.out.println();

            System.out.print("Username: ");
            username = scanner.nextLine();

            // Show entered username
            System.out.println(username);

            System.out.print("Password: ");
            password = scanner.nextLine();

            // Show entered password
            System.out.println(password);

            walletBalance = 0.00;
            pcMinutes = 0;
            registered = true;

            System.out.println();
            System.out.println("Registration successful!");
            System.out.println();
            System.out.println("Welcome to PC Café, " + username + "!");
            System.out.println();
            System.out.printf(
                    "E-Wallet Balance: ₱%.2f%n",
                    walletBalance
            );
            System.out.println(
                    "PC Time: " + pcMinutes + " minutes"
            );
        }
    }

    // =========================================================
    // 2. E-WALLET
    // =========================================================
    class EWallet {

        public void runFeature(Scanner scanner) {

            if (!registered) {
                System.out.println();
                System.out.println(
                        "Please register an account first."
                );
                return;
            }

            boolean back = false;

            while (!back) {

                System.out.println();
                System.out.println("================================");
                System.out.println("       PC CAFÉ E-WALLET");
                System.out.println("================================");
                System.out.println();

                System.out.printf(
                        "Current Balance: ₱%.2f%n",
                        walletBalance
                );

                System.out.println();
                System.out.println("1. Add Money");
                System.out.println("2. Check Balance");
                System.out.println("3. Back");
                System.out.println();

                System.out.print("Enter option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                System.out.println(option);

                switch (option) {

                    case 1:

                        System.out.println();
                        System.out.print(
                                "Enter amount to add: ₱"
                        );

                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        // Show entered amount
                        System.out.println(
                                String.format("%.0f", amount)
                        );

                        if (amount <= 0) {

                            System.out.println();
                            System.out.println(
                                    "Invalid amount."
                            );

                        } else {

                            walletBalance += amount;

                            System.out.println();

                            System.out.printf(
                                    "₱%.2f added successfully!%n",
                                    amount
                            );

                            System.out.printf(
                                    "New Balance: ₱%.2f%n",
                                    walletBalance
                            );
                        }

                        break;

                    case 2:

                        System.out.println();

                        System.out.printf(
                                "Current E-Wallet Balance: ₱%.2f%n",
                                walletBalance
                        );

                        break;

                    case 3:
                        back = true;
                        break;

                    default:

                        System.out.println();
                        System.out.println(
                                "Invalid option."
                        );
                }
            }
        }
    }

    // =========================================================
    // 3. BUY PC HOURS
    // =========================================================
    class PCHours {

        public void runFeature(Scanner scanner) {

            if (!registered) {

                System.out.println();
                System.out.println(
                        "Please register an account first."
                );

                return;
            }

            boolean back = false;

            while (!back) {

                System.out.println();
                System.out.println("================================");
                System.out.println("          BUY PC HOURS");
                System.out.println("================================");
                System.out.println();

                System.out.printf(
                        "E-Wallet Balance: ₱%.2f%n",
                        walletBalance
                );

                System.out.println(
                        "Current PC Time: "
                                + pcMinutes
                                + " minutes"
                );

                System.out.println();
                System.out.println("1. ₱15 - 1 Hour");
                System.out.println("2. ₱25 - 2 Hours");
                System.out.println("3. ₱50 - 4 Hours");
                System.out.println("4. ₱60 - 5 Hours");
                System.out.println("5. ₱100 - 10 Hours");
                System.out.println("6. Back");
                System.out.println();

                System.out.print("Enter option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                System.out.println(option);

                switch (option) {

                    case 1:
                        buyPC(15, 60);
                        break;

                    case 2:
                        buyPC(25, 120);
                        break;

                    case 3:
                        buyPC(50, 240);
                        break;

                    case 4:
                        buyPC(60, 300);
                        break;

                    case 5:
                        buyPC(100, 600);
                        break;

                    case 6:
                        back = true;
                        break;

                    default:

                        System.out.println();
                        System.out.println(
                                "Invalid option."
                        );
                }
            }
        }

        private void buyPC(
                double price,
                int minutes
        ) {

            System.out.println();

            if (walletBalance < price) {

                System.out.println(
                        "Insufficient E-Wallet balance."
                );

                System.out.printf(
                        "You need ₱%.2f.%n",
                        price
                );

                return;
            }

            walletBalance -= price;
            pcMinutes += minutes;

            System.out.println(
                    "PC hours purchased successfully!"
            );

            System.out.printf(
                    "₱%.2f deducted from E-Wallet.%n",
                    price
            );

            System.out.printf(
                    "Remaining Balance: ₱%.2f%n",
                    walletBalance
            );

            System.out.println(
                    "Available PC Time: "
                            + pcMinutes
                            + " minutes"
            );
        }
    }

    // =========================================================
    // 4. FOOD AND DRINKS
    // =========================================================
    class FoodAndDrinks {

        public void runFeature(Scanner scanner) {

            if (!registered) {

                System.out.println();
                System.out.println(
                        "Please register an account first."
                );

                return;
            }

            boolean back = false;

            while (!back) {

                System.out.println();
                System.out.println("================================");
                System.out.println("        FOOD AND DRINKS");
                System.out.println("================================");
                System.out.println();

                System.out.printf(
                        "E-Wallet Balance: ₱%.2f%n",
                        walletBalance
                );

                System.out.println();

                System.out.println("--- FOOD ---");
                System.out.println(
                        "1. Pancit Canton    ₱30"
                );
                System.out.println(
                        "2. Burger           ₱20"
                );
                System.out.println(
                        "3. Fries            ₱25"
                );

                System.out.println();

                System.out.println("--- DRINKS ---");
                System.out.println(
                        "4. Coke             ₱25"
                );
                System.out.println(
                        "5. Mountain Dew     ₱20"
                );
                System.out.println(
                        "6. Bottled Water    ₱10"
                );

                System.out.println();
                System.out.println("7. Back");
                System.out.println();

                System.out.print("Enter option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                System.out.println(option);

                switch (option) {

                    case 1:
                        buyFood(
                                "Pancit Canton",
                                30
                        );
                        break;

                    case 2:
                        buyFood(
                                "Burger",
                                20
                        );
                        break;

                    case 3:
                        buyFood(
                                "Fries",
                                25
                        );
                        break;

                    case 4:
                        buyFood(
                                "Coke",
                                25
                        );
                        break;

                    case 5:
                        buyFood(
                                "Mountain Dew",
                                20
                        );
                        break;

                    case 6:
                        buyFood(
                                "Bottled Water",
                                10
                        );
                        break;

                    case 7:
                        back = true;
                        break;

                    default:

                        System.out.println();
                        System.out.println(
                                "Invalid option."
                        );
                }
            }
        }

        private void buyFood(
                String item,
                double price
        ) {

            System.out.println();

            if (walletBalance < price) {

                System.out.println(
                        "Insufficient E-Wallet balance."
                );

                return;
            }

            walletBalance -= price;

            System.out.println(
                    item + " purchased successfully!"
            );

            System.out.printf(
                    "₱%.2f deducted from E-Wallet.%n",
                    price
            );

            System.out.printf(
                    "Remaining Balance: ₱%.2f%n",
                    walletBalance
            );
        }
    }

    // =========================================================
    // 5. LOGIN TO PC
    // =========================================================
    class PCLogin {

        public void runFeature(Scanner scanner) {

            if (!registered) {

                System.out.println();
                System.out.println(
                        "Please register an account first."
                );

                return;
            }

            System.out.println();
            System.out.println("================================");
            System.out.println("          LOGIN TO PC");
            System.out.println("================================");
            System.out.println();

            System.out.print("Username: ");

            String inputUsername =
                    scanner.nextLine();

            // Show entered username
            System.out.println(inputUsername);

            System.out.print("Password: ");

            String inputPassword =
                    scanner.nextLine();

            // Show entered password
            System.out.println(inputPassword);

            if (!username.equals(inputUsername)
                    || !password.equals(inputPassword)) {

                System.out.println();
                System.out.println(
                        "Invalid username or password."
                );

                return;
            }

            if (pcMinutes <= 0) {

                System.out.println();
                System.out.println(
                        "No PC time available. "
                                + "Please purchase PC hours first."
                );

                return;
            }

            System.out.println();
            System.out.println(
                    "Login successful!"
            );

            System.out.println(
                    "Available PC Time: "
                            + pcMinutes
                            + " minutes"
            );

            new PCSession().runFeature();
        }
    }

    // =========================================================
    // PC SESSION
    // =========================================================
    class PCSession {

        public void runFeature() {

            System.out.println();
            System.out.println(
                    "Starting PC session..."
            );

            System.out.println();

            while (pcMinutes > 10) {

                pcMinutes -= 10;

                System.out.println(
                        "10 minutes passed..."
                );

                System.out.println(
                        "Time Remaining: "
                                + pcMinutes
                                + " minutes"
                );

                System.out.println();
            }

            if (pcMinutes == 10) {

                System.out.println(
                        "================================"
                );
                System.out.println(
                        "          ⚠ WARNING"
                );
                System.out.println(
                        "================================"
                );
                System.out.println();

                System.out.println(
                        "You only have 10 minutes"
                );

                System.out.println(
                        "of PC time remaining!"
                );

                System.out.println();

                System.out.println(
                        "Please prepare to end your session"
                );

                System.out.println(
                        "or purchase additional PC hours"
                );

                System.out.println(
                        "if you wish to continue playing."
                );

                System.out.println();

                System.out.println(
                        "Fast-forwarding to session end..."
                );

                System.out.println();

                System.out.println(
                        "Time Remaining: 10 seconds"
                );

                System.out.println();

                System.out.println(
                        "================================"
                );
                System.out.println(
                        "       SESSION ENDING"
                );
                System.out.println(
                        "================================"
                );

                System.out.println();

                for (int i = 10; i >= 1; i--) {

                    System.out.println(
                            i + "..."
                    );
                }

                pcMinutes = 0;

                System.out.println();

                System.out.println(
                        "================================"
                );
                System.out.println(
                        "        TIME EXPIRED"
                );
                System.out.println(
                        "================================"
                );

                System.out.println();

                System.out.println(
                        "Your PC time has expired."
                );

                System.out.println();

                System.out.println(
                        "Automatically logging out..."
                );

                System.out.println();

                System.out.println(
                        "PC session ended."
                );
            }
        }
    }
}