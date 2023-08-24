package week02;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CSVReaderApp {
    public static void main(String[] args) {
        InputStream inputStream = CSVReaderApp.class.getResourceAsStream("/data.csv");

        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream)).withSkipLines(1).build()) {
            String[] headers = csvReader.readNext();

            Set<String>[] columnValues = new HashSet[headers.length];
            for (int i = 0; i < headers.length; i++) {
                columnValues[i] = new HashSet<>();
            }

            String[] row;
            while ((row = csvReader.readNext()) != null) {
                for (int i = 0; i < row.length; i++) {
                    columnValues[i].add(row[i]);
                }
            }

            for (int i = 0; i < headers.length; i++) {
                System.out.println("Column: " + headers[i]);
                System.out.println("Unique Values: " + columnValues[i]);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
