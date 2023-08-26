package project;

import java.util.*;

import static project.TradeAnalyzerCalculator.*;

public class TradeAnalyzerApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            List<TradeData> tradeDataList = TradeDataReader.readTradeDataFromCSV("/Users/Walid/Desktop/Becode/The Mountain/Java/CleanProject/src/main/resources/covid_and_trade.csv");

            int calculationType;
            do {
                System.out.println("Choose calculation type:");
                System.out.println("1. Monthly Total");
                System.out.println("2. Monthly Average");
                System.out.println("3. Yearly Total");
                System.out.println("4. Yearly Average");
                System.out.println("5. Overview");
                System.out.println("6. Help");
                System.out.println("7. Help <command>");
                System.out.println("8. Exit");

                System.out.print("Enter the calculation type: ");
                calculationType = scanner.nextInt();

                if (calculationType == 6 || calculationType == 7) {
                    if (calculationType == 6) {
                        displayHelp();
                    } else {
                        displayHelpForSpecificCommand(scanner);
                    }
                } else if (calculationType >= 1 && calculationType <= 5) {
                    processCalculationType(calculationType, scanner, tradeDataList);
                    scanner.nextLine();
                    System.out.print("Would you like to run something else? (y/n): ");
                    String continueChoice = scanner.nextLine();
                    if (continueChoice.equalsIgnoreCase("n")) {
                        break;
                    }
                } else if (calculationType == 8) {
                    System.out.println("Exiting the program.");
                } else {
                    System.out.println("Invalid calculation type.");
                }
            } while (calculationType != 8);

            scanner.close();
        }

    private static void processCalculationType(int calculationType, Scanner scanner, List<TradeData> tradeDataList) {
        switch (calculationType) {
            case 1:
                System.out.print("Enter the desired year: ");
                int desiredYear = scanner.nextInt();
                System.out.print("Enter the desired month (e.g., 01 for January): ");
                String desiredMonth = scanner.next();
                calculateMonthlyTotal(tradeDataList, desiredYear, desiredMonth);
                break;
            case 2:
                System.out.print("Enter the desired year: ");
                desiredYear = scanner.nextInt();
                System.out.print("Enter the desired month (e.g., 01 for January): ");
                desiredMonth = scanner.next();
                calculateMonthlyAverage(tradeDataList, desiredYear, desiredMonth);
                break;
            case 3:
                System.out.print("Enter the desired year: ");
                desiredYear = scanner.nextInt();
                calculateYearlyTotal(tradeDataList, desiredYear);
                break;
            case 4:
                System.out.print("Enter the desired year: ");
                desiredYear = scanner.nextInt();
                calculateYearlyAverage(tradeDataList, desiredYear);
                break;
            case 5:
                Set<Integer> uniqueYears = new HashSet<>();
                Set<String> uniqueCountries = new HashSet<>();
                Set<String> uniqueCommodities = new HashSet<>();
                Set<String> uniqueTransportModes = new HashSet<>();
                Set<String> uniqueMeasures = new HashSet<>();

                for (TradeData tradeData : tradeDataList) {
                    uniqueYears.add(tradeData.year);
                    uniqueCountries.add(tradeData.country);
                    uniqueCommodities.add(tradeData.commodity);
                    uniqueTransportModes.add(tradeData.transportationMode);
                    uniqueMeasures.add(tradeData.measure);
                }
                System.out.println("Unique Years: " + uniqueYears);
                System.out.println("Unique Countries: " + uniqueCountries);
                System.out.println("Unique Commodities: " + uniqueCommodities);
                System.out.println("Unique Transportation Modes: " + uniqueTransportModes);
                System.out.println("Unique Measures: " + uniqueMeasures);
                break;
            default:
                System.out.println("No explanation available for the selected command.");
        }
    }

    private static void displayHelpForSpecificCommand(Scanner scanner) {
        System.out.print("Enter the command number (1-5) for which you need help: ");
        int commandNumber = scanner.nextInt();
        scanner.nextLine();
        displayHelpForCommand(commandNumber);
    }

    public static void displayHelp() {
        System.out.println("Available Commands:");
        System.out.println("1. Monthly Total - Calculate monthly total for a specified year and month.");
        System.out.println("2. Monthly Average - Calculate monthly average for a specified year and month.");
        System.out.println("3. Yearly Total - Calculate yearly total for a specified year.");
        System.out.println("4. Yearly Average - Calculate yearly average for a specified year.");
        System.out.println("5. Overview - Display unique values for years, countries, commodities, etc.");
        System.out.println("6. Help - Display this list of available commands.");
    }

    public static void displayHelpForCommand(int command) {
        switch (command) {
            case 1:
                System.out.println("Monthly Total Command:");
                System.out.println("Calculates the sum of both the export and import values for a specified month and year.");
                System.out.println("Parameters: desired year, desired month");
                break;
            case 2:
                System.out.println("Monthly Average Command:");
                System.out.println("Calculates the average of both the export and import values for a specified month and year.");
                System.out.println("Parameters: desired year, desired month");
                break;
            case 3:
                System.out.println("Yearly Total Command:");
                System.out.println("Calculates the sum of both the export and import values for a specified year.");
                System.out.println("Parameters: desired year");
                break;
            case 4:
                System.out.println("Yearly Average Command:");
                System.out.println("Calculates the average of both the export and import values for a specified year.");
                System.out.println("Parameters: desired year");
                break;
            case 5:
                System.out.println("Overview Command:");
                System.out.println("Displays all unique values that span the data set: years, countries, commodities, transportation modes, and measures.");
                break;
            default:
                System.out.println("No explanation available for the selected command.");
        }
    }
}
