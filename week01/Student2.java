package week01;

import java.util.ArrayList;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.InputStream;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class CSVFile {
    private List<String[]> data;

    public CSVFile(InputStream inputStream) {
        data = new ArrayList<>();
        processCSV(inputStream);
    }

    private void processCSV(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream)) {
            boolean skipHeader = true; // Skip the first line (header)
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getData() {
        return data;
    }
}



class ReportGenerator {
    private List<String[]> data;

    public ReportGenerator(List<String[]> data) {
        this.data = data;
    }

    public String generateDailyReport(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(date);

        StringBuilder report = new StringBuilder();
        report.append("Daily Report - ").append(formattedDate).append("\n");

        for (String[] row : data) {
            report.append("Department: ").append(row[0]);
            report.append(", Visitors: ").append(row[1]);
            report.append("\n");
        }

        return report.toString();
    }

    public String generateMonthlyReport(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
        String formattedDate = dateFormat.format(date);

        Map<String, Integer> departmentVisitorsMap = new HashMap<>();

        for (String[] row : data) {
            String department = row[0];
            int visitors = Integer.parseInt(row[1]);

            departmentVisitorsMap.put(department, departmentVisitorsMap.getOrDefault(department, 0) + visitors);
        }

        StringBuilder report = new StringBuilder();
        report.append("Monthly Report - ").append(formattedDate).append("\n");

        for (Map.Entry<String, Integer> entry : departmentVisitorsMap.entrySet()) {
            report.append("Department: ").append(entry.getKey());
            report.append(", Total Visitors: ").append(entry.getValue());
            report.append("\n");
        }

        return report.toString();
    }
}

class ReportFileWriter {
    public static void writeReportToFile(String report, String filePath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



public class Student2 {
    public static void main(String[] args) {
        String csvFilePath = "/students2.csv";

        try (InputStream inputStream = Student2.class.getResourceAsStream(csvFilePath)) {
            CSVFile csvFile = new CSVFile(inputStream);
            ReportGenerator reportGenerator = new ReportGenerator(csvFile.getData());

            String dailyReport = reportGenerator.generateDailyReport(new Date());
            System.out.println("Generated Daily Report:\n" + dailyReport);

            String dailyReportFilePath = "app/src/main/resources/daily_report.csv";
            ReportFileWriter.writeReportToFile(dailyReport, dailyReportFilePath);
            System.out.println("Daily Report saved to file: " + dailyReportFilePath);

            String monthlyReport = reportGenerator.generateMonthlyReport(new Date());
            System.out.println("Generated Monthly Report:\n" + monthlyReport);

            String monthlyReportFilePath = "app/src/main/resources/monthly_report.csv";
            ReportFileWriter.writeReportToFile(monthlyReport, monthlyReportFilePath);
            System.out.println("Monthly Report saved to file: " + monthlyReportFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}