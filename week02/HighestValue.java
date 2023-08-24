package week02;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighestValue {
    public static void main(String[] args) {
        String csvFilePath = "/data.csv";

        try {
            InputStream inputStream = Filtering.class.getResourceAsStream(csvFilePath);
            InputStreamReader reader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            String[] header = {"Direction", "Year", "Date", "Weekday", "Country", "Commodity", "Transport_Mode", "Measure", "Value", "Cumulative"};

            String[] highestValueRow = null;
            double maxDoubleValue = Double.MIN_VALUE;

            String[] values;
            while ((values = csvReader.readNext()) != null) {
                String date = values[2];
                String year = date.split("/")[2];
                String country = values[4];
                String commodity = values[5];
                String transport_mode = values[6];
                String value = values[8];

                if ((year.equals("2019")) && (country.equals("China")) && (commodity.equals("All")) && (transport_mode.equals("All"))) {
                    double doubleValue = Double.parseDouble(value);
                    if (doubleValue > maxDoubleValue) {
                        maxDoubleValue = doubleValue;
                        highestValueRow = values.clone();
                    }
                }
            }

            csvReader.close();
            reader.close();
            inputStream.close();

            if (highestValueRow != null) {
                FileWriter writer = new FileWriter("/Users/Walid/Desktop/Becode/The Mountain/Java/older/app/src/main/resources/data2019.csv");
                CSVWriter csvWriter = new CSVWriter(writer);

                csvWriter.writeNext(header);
                csvWriter.writeNext(highestValueRow);

                csvWriter.flush();
                csvWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
