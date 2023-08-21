package week01;

import java.util.HashMap;
import java.util.Map;

public class ReadLetters {
    //     public static void main(String[] args) {
    //     String inputText = "I have said earlier today that i cant study also i cant work today this is why for best option is to go home today to work and study from there, What do you mean by that ? Are you kiddiing me? You must be joking right? i dont get it? why are so mad at me?";

    //     String cleanedText = inputText.replaceAll("[^a-zA-Z]", "").toLowerCase();

    //     System.out.println(cleanedText);
    //     char[] letters = cleanedText.toCharArray();

    //     Map<Character, Integer> letterCounts = new HashMap<>();

    //     for (char letter : letters) {
    //         if (letterCounts.containsKey(letter)) {
    //             letterCounts.put(letter, letterCounts.get(letter) + 1);
    //         } else {
    //             letterCounts.put(letter, 1);
    //         }
    //     }

    //     System.out.println("Letter Counts:");
    //     for (Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {
    //         System.out.println(entry.getKey() + ": " + entry.getValue());
    //     }
    // }


    public static void main(String[] args) {
        String inputText = "I have said earlier today that i cant study also i cant work today this is why for best option is to go home today to work and study from there, What do you mean by that ? Are you kiddiing me? You must be joking right? i dont get it? why are so mad at me?";

        String cleanedText = inputText.toLowerCase();
        System.out.println(cleanedText);


        Map<Character, Integer> letterCounts = new HashMap<>();

        for (char letter = 'a'; letter <= 'z'; letter++) {
            letterCounts.put(letter, 0);
        }

        for (int i = 0; i < cleanedText.length(); i++) {
            char character = cleanedText.charAt(i);
            if (Character.isLetter(character)) {
                letterCounts.put(character, letterCounts.get(character) + 1);
            }
        }

        System.out.println("Letter Counts:");
        for (Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
