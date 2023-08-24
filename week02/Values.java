package week02;

import java.io.*;
import java.util.*;

public class Values {

    public static void main(String[] args) {
        String csvFilePath = "data.csv";

        // Read and process the CSV file using the Stream API
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Values.class.getResourceAsStream("/" + csvFilePath)))) {
            String line;
            boolean firstLine = true;

            Map<Integer, Set<String>> columnValues = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] values = line.split(",");

                // Use Stream API to populate columnValues with unique values
                for (int i = 0; i < values.length; i++) {
                    int columnIndex = i;
                    columnValues.computeIfAbsent(columnIndex, k -> new HashSet<>()).add(values[columnIndex]);
                }
            }

            // Sort and display unique values for each column
            columnValues.forEach((index, values) -> {
                List<String> sortedValues = new ArrayList<>(values);
                Collections.sort(sortedValues);

                System.out.println("Unique values in column " + (index + 1) + ": " + sortedValues);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
