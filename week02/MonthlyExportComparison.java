package week02;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MonthlyExportComparison {
    public static void main(String[] args) {
        String csvFilePath = "/data.csv";

        try {
            InputStream inputStream = MonthlyExportComparison.class.getResourceAsStream(csvFilePath);
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            line = bufferedReader.readLine();

            List<TradeData> tradeDataList = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                tradeDataList.add(new TradeData(values));
            }

            reader.close();
            inputStream.close();

            Map<String, Double> exportValues2019 = tradeDataList.stream()
                    .filter(data -> data.getCountry().contains("European Union"))
                    .filter(data -> data.getYear().equals("2019"))
                    .collect(Collectors.groupingBy(TradeData::getMonth,
                            Collectors.summingDouble(TradeData::getExportValue)));

            Map<String, Double> exportValues2020 = tradeDataList.stream()
                    .filter(data -> data.getCountry().contains("European Union"))
                    .filter(data -> data.getYear().equals("2020"))
                    .collect(Collectors.groupingBy(TradeData::getMonth,
                            Collectors.summingDouble(TradeData::getExportValue)));

            writeMapToCSV(exportValues2019, "/Users/Walid/Desktop/Becode/The Mountain/Java/older/app/src/main/resources/ExportValues2019.csv");
            writeMapToCSV(exportValues2020, "/Users/Walid/Desktop/Becode/The Mountain/Java/older/app/src/main/resources/ExportValues2020.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeMapToCSV(Map<String, Double> map, String fileName) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write("Month,SumExportValue\n");
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            writer.write(entry.getKey() + "," + entry.getValue() + "\n");
        }
        writer.close();
    }
}

class TradeData {
    private String year;
    private String month;
    private String country;
    private double exportValue;

    public TradeData(String[] values) {
        this.year = values[1];
        this.month = values[2].split("/")[1];
        this.country = values[4];
        try {
            this.exportValue = Double.parseDouble(values[8]);
        } catch (NumberFormatException e) {
            this.exportValue = 0;
        }
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getCountry() {
        return country;
    }

    public double getExportValue() {
        return exportValue;
    }
}
