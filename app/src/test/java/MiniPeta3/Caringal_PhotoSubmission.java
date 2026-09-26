package MiniPeta3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Caringal_PhotoSubmission {

    @Test
    public void testPhotoSubmission() {

        /*
         * Simulated user input
         *
         * 1 = Take Photo
         * 2 = Choose from Gallery
         * 3 = Add Caption
         * 4 = Submit Photo
         * 5 = Exit
         */
        StringBuilder simulatedUserInput = new StringBuilder();

        simulatedUserInput.append("2\n"); // Choose from Gallery
        simulatedUserInput.append("3\n"); // Add Caption
        simulatedUserInput.append("Road cleaned and surroundings are clean.\n");
        simulatedUserInput.append("4\n"); // Submit Photo
        simulatedUserInput.append("5\n"); // Exit

        // Convert simulated input into a Scanner
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(simulatedUserInput.toString().getBytes());

        Scanner scanner = new Scanner(inputStream);

        boolean running = true;
        boolean photoSelected = false;
        boolean submitted = false;

        String caption = "";

        System.out.println("=================================");
        System.out.println("       PHOTO SUBMISSION");
        System.out.println("=================================");
        System.out.println("Task ID: TSK-2024-00123");
        System.out.println("Task: Sweep and clean the Barangay Road");
        System.out.println("      and surrounding area.");
        System.out.println();

        while (running && scanner.hasNextLine()) {

            System.out.println("---------------------------------");
            System.out.println("1. Take Photo");
            System.out.println("2. Choose from Gallery");
            System.out.println("3. Add Caption");
            System.out.println("4. Submit Photo");
            System.out.println("5. Exit");
            System.out.println("---------------------------------");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    // Take Photo
                    System.out.println("Taking photo...");
                    photoSelected = true;
                    System.out.println("Photo captured successfully.");
                    break;

                case 2:
                    // Choose from Gallery
                    System.out.println("Opening Gallery...");
                    photoSelected = true;
                    System.out.println("Photo selected from gallery.");
                    break;

                case 3:
                    // Add Caption
                    System.out.println("Enter caption:");

                    if (scanner.hasNextLine()) {
                        caption = scanner.nextLine();

                        if (caption.length() > 100) {
                            System.out.println("Caption is too long.");
                        } else {
                            System.out.println("Caption added:");
                            System.out.println(caption);
                        }
                    }
                    break;

                case 4:
                    // Submit Photo
                    if (!photoSelected) {
                        System.out.println("ERROR: Please select or take a photo first.");
                    } else {
                        System.out.println("Submitting photo...");

                        if (caption.isEmpty()) {
                            System.out.println("Photo submitted without caption.");
                        } else {
                            System.out.println("Photo submitted with caption:");
                            System.out.println(caption);
                        }

                        submitted = true;
                        System.out.println("PHOTO SUBMISSION SUCCESSFUL.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting Photo Submission.");
                    running = false;
                    break;

                default:
                    // Invalid choice
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();

        // Simple test verification
        assert photoSelected : "Photo should have been selected.";
        assert submitted : "Photo should have been submitted.";

        System.out.println();
        System.out.println("=================================");
        System.out.println("         TEST COMPLETED");
        System.out.println("=================================");
    }
}
