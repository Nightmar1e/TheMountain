package project;

import java.util.Scanner;

public class InputUtils {
    public static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (input.matches("\\d{2}")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid 2-digit month.");
            }
        }
    }
}
