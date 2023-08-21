package week01;

import java.util.HashMap; // store words as keys and their corresponding counts as values
import java.util.Map;

public class ReadTeaxt {
    public static void main(String[] args) {
        String inputText = "I have said earlier today that i cant study also i cant work today this is why for best option is to go home today to work and study from there, What do you mean by that ? Are you kiddiing me? You must be joking right? i dont get it? why are so mad at me?";

        String[] words = inputText.split("\\W+"); // splited by non-word characters
        
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : words) {
            word = word.toLowerCase(); // Convert to lowercase for case-insensitive counting
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        System.out.println("Word Counts:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
