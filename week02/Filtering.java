package week02;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Filtering {

    public static void main(String[] args) {
        String csvFilePath = "/data.csv";

        try {
            InputStream inputStream = Filtering.class.getResourceAsStream(csvFilePath);
            InputStreamReader reader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            FileWriter writer = new FileWriter("/Users/Walid/Desktop/Becode/The Mountain/Java/older/app/src/main/resources/data2016.csv");
            CSVWriter csvWriter = new CSVWriter(writer);

            String[] header = {"Direction", "Year", "Date", "Weekday", "Country", "Commodity", "Transport_Mode", "Measure", "Value", "Cumulative"};
            csvWriter.writeNext(header);

            String[] values;
            while ((values = csvReader.readNext()) != null) {
                String date = values[2];
                String year = date.split("/")[2];

                if (year.equals("2016")) {
                    csvWriter.writeNext(values);
                }
            }

            csvWriter.flush();
            csvWriter.close();

            csvReader.close();
            reader.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
