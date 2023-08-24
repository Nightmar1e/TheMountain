package week02;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SumOfExportValues {
    public static void main(String[] args) {
        String csvFilePath = "/data.csv";

        try {
            InputStream inputStream = SumOfExportValues.class.getResourceAsStream(csvFilePath);
            InputStreamReader reader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(new FileWriter("/Users/Walid/Desktop/Becode/The Mountain/Java/older/app/src/main/resources/sumExportValues.csv")).build();

            String[] values;
            double sumOfExportValues = 0.0;

            while ((values = csvReader.readNext()) != null) {
                String direction = values[0];
                String date = values[2];
                String year = date.split("/")[2];
                String country = values[4];
                String commodity = values[5];
                String transport_mode = values[6];
                String value = values[8];

                if ((direction.equals("Exports")) && (year.equals("2019")) && (country.equals("China")) && (commodity.equals("All")) && (transport_mode.equals("All"))) {
                    double doubleValue = Double.parseDouble(value);
                    sumOfExportValues += doubleValue;
                }
            }

            csvReader.close();
            reader.close();
            inputStream.close();

            csvWriter.writeNext(new String[]{"Sum of Export Values"});
            csvWriter.writeNext(new String[]{String.valueOf(sumOfExportValues)});
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
