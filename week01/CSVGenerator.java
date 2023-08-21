package week01;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class CSVGenerator {
    private static final String[] FIRST_NAMES = {
            "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack",
            "Karen", "Leo", "Mia", "Noah", "Olivia", "Peter", "Quincy", "Rachel", "Sam", "Taylor",
            "Uma", "Victor", "Wendy", "Xavier", "Yara", "Zane"
    };

    private static final String[] LAST_NAMES = {
            "Adams", "Brown", "Carter", "Davis", "Evans", "Foster", "Garcia", "Harris", "Ingram", "Johnson",
            "Klein", "Lee", "Martin", "Nguyen", "O'Connor", "Parker", "Quinn", "Roberts", "Smith", "Taylor",
            "Upton", "Vargas", "Williams", "Xu", "Young", "Zhang"
    };

    private static final String[] REASONS = { "Appointment", "Visit" };

    private static final String[] DEPARTMENTS = {
            "Cardiology", "Radiology", "Pediatrics", "Geriatrics", "Pulmonology"
    };

    private static final int NUM_RECORDS = 50; // Number of records to generate

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("app/src/main/resources/generated_data.csv")) {
            writer.write("First Name,Last Name,Reason,Department,Date of Visit\n");

            for (int i = 0; i < NUM_RECORDS; i++) {
                String firstName = getRandomElement(FIRST_NAMES);
                String lastName = getRandomElement(LAST_NAMES);
                String reason = getRandomElement(REASONS);
                String department = reason.equals("Appointment") ? getRandomElement(DEPARTMENTS) : "";
                String dateOfVisit = generateRandomDate();

                writer.write(firstName + "," + lastName + "," + reason + "," + department + "," + dateOfVisit + "\n");
            }

            System.out.println("CSV file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> T getRandomElement(T[] array) {
        int index = RANDOM.nextInt(array.length);
        return array[index];
    }

    private static String generateRandomDate() {
        int year = 2023; // Current year
        int month = 8;   // August (0-indexed)
        int day = 1 + RANDOM.nextInt(31); // Random day within the month

        return DATE_FORMAT.format(new Date(year - 1900, month, day));
    }
}
