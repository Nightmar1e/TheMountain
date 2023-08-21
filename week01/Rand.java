package week01;

//random array of non-primitive integers

import java.util.Random;
public class Rand {
    public static void main(String[] args) {
        int maxSize = 10; // the length of the array is 10
        int[] randomArray = new int[maxSize];
        Random random = new Random();

        for (int i = 0; i < maxSize; i++) {
            randomArray[i] = random.nextInt(67); // random generate numbers between 0 and 66
        }

        System.out.println("Generated Array:");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println(); // print a new line

        System.out.println("Results after Division:");
        for (int i = 0; i < maxSize; i++) {
            if (i == 0) {
                System.out.println(randomArray[i]);  // print first number
            } else {
                if (randomArray[i - 1] != 0) { // added the if statement to prevent crashing
                    double divisionResult = (double) randomArray[i] / randomArray[i - 1];
                    System.out.println(divisionResult);
                } else {
                    System.out.println("Cannot divide by zero");
        }
    }
    }
}
}
