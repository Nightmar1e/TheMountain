package week02;

import java.util.Scanner;

enum MeasurementUnit {
    METERS,
    CENTIMETERS,
    MILLIMETERS;

    public static boolean isCorrectUnit(String unitString) {
        return unitString.endsWith("m") || unitString.endsWith("cm") || unitString.endsWith("mm");
    }
}

class SurfaceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = getInputMeasurement("length", scanner);
        double width = getInputMeasurement("width", scanner);

        MeasurementUnit unit = getInputUnit(scanner);

        double lengthInMeters = convertToMeters(length, unit);
        double widthInMeters = convertToMeters(width, unit);

        double surfaceArea = calculateSurfaceArea(lengthInMeters, widthInMeters);
        System.out.println("Surface Area: " + surfaceArea + " square meters");

        scanner.close();
    }

    private static double getInputMeasurement(String dimension, Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter " + dimension + ": ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }
    }

    private static MeasurementUnit getInputUnit(Scanner scanner) {
        while (true) {
            System.out.print("Enter unit (m/cm/mm): ");
            String unitString = scanner.nextLine().toLowerCase();

            if (unitString.equals("m")) {
                return MeasurementUnit.METERS;
            } else if (unitString.equals("cm")) {
                return MeasurementUnit.CENTIMETERS;
            } else if (unitString.equals("mm")) {
                return MeasurementUnit.MILLIMETERS;
            } else {
                System.out.println("Invalid unit. Please enter 'm', 'cm', or 'mm'.");
            }
        }
    }

    private static double convertToMeters(double value, MeasurementUnit unit) {
        if (unit == MeasurementUnit.CENTIMETERS) {
            return value / 100.0;  // Conversion from centimeters to meters
        } else if (unit == MeasurementUnit.MILLIMETERS) {
            return value / 1000.0; // Conversion from millimeters to meters
        } else {
            return value; // Already in meters
        }
    }

    private static double calculateSurfaceArea(double length, double width) {
        return length * width;
    }
}

class Measurements {
    public static void main(String[] args) {
        SurfaceCalculator.main(args);
    }
}
