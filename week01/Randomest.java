package week01;

import java.util.Random;

public class Randomest {
    public static void main(String[] args) {
        int maxSize = 4; // the length of the array is 4
        int upperLimit = 2; // the printed numebrs should be <= 2
        int[] randomArray = new int[maxSize];
        Random random = new Random();

        for (int i = 0; i < maxSize; i++) {
            randomArray[i] = random.nextInt(67); // random generate numbers between 0 and 66
        }
        System.out.println("Generated Array:");
        for (int i = 0; i < maxSize; i++) {
            System.out.println(randomArray[i]);
        }
        System.out.println("Numbers smaller than " + upperLimit + ":");
        for (int i = 0; i < maxSize; i++) {
            if (randomArray[i] < upperLimit) {
                System.out.println(randomArray[i]);
            }
        }
    }
}
