package week02;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreFiltering {
    public static void main(String[] args) {
        String csvFilePath = "/data.csv";

        try {
            InputStream inputStream = Filtering.class.getResourceAsStream(csvFilePath);
            InputStreamReader reader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            String[] header = {"Direction", "Year", "Date", "Weekday", "Country", "Commodity", "Transport_Mode", "Measure", "Value", "Cumulative"};

            List<String[]> sortedAndFilteredData = new ArrayList<>();

            String[] values;
            while ((values = csvReader.readNext()) != null) {
                String date = values[2];
                String year = date.split("/")[2];
                String country = values[4];
                String commodity = values[5];
                String transport_mode = values[6];
                String value = values[8];

                if ((year.equals("2018")) && (country.equals("All")) && (commodity.equals("All")) && (transport_mode.equals("All"))) {
                    sortedAndFilteredData.add(values);
                }
            }

            csvReader.close();
            reader.close();
            inputStream.close();

            sortedAndFilteredData.sort(Comparator.comparingDouble(row -> Double.parseDouble(row[8])));

            FileWriter writer = new FileWriter("/Users/Walid/Desktop/Becode/The Mountain/Java/older/app/src/main/resources/data2018.csv");
            CSVWriter csvWriter = new CSVWriter(writer);

            csvWriter.writeNext(header);
            sortedAndFilteredData.forEach(csvWriter::writeNext);

            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
