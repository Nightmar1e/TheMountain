package week01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        // Divide the files among team members
        String[] files = { "app/src/main/resources/daily_report.csv", "app/src/main/resources/generated_data.csv", "app/src/main/resources/monthly_report.csv" };

        Map<String, Integer> wordCountMap = new HashMap<>();

        // Process assigned files and update word count map
        for (String file : files) {
            Map<String, Integer> fileWordCountMap = countWordsInFile(file);
            mergeMaps(wordCountMap, fileWordCountMap);
        }

        // Generate and display the report
        generateReport(wordCountMap);
    }

    public static Map<String, Integer> countWordsInFile(String fileName) {
        Map<String, Integer> fileWordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase(); // Normalize words
                    fileWordCountMap.put(word, fileWordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileWordCountMap;
    }

    public static void mergeMaps(Map<String, Integer> destination, Map<String, Integer> source) {
        for (Map.Entry<String, Integer> entry : source.entrySet()) {
            destination.put(entry.getKey(), destination.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    public static void generateReport(Map<String, Integer> wordCountMap) {
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
