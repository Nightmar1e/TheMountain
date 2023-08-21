package week01;
import java.util.Random;
public class Primitive {

    public static void main(String[] args) {
        int maxSize = 10; 
        int upperLimit = 10;
        int[] randomArray = new int[maxSize];

        Random random = new Random();
        for (int i = 0; i < maxSize; i++) {
            randomArray[i] = random.nextInt(20); // Generate random numbers between 0 and 19
        }

        // Print numbers smaller than the specified upper limit
        System.out.println("Numbers smaller than " + upperLimit + ":");
        for (int num : randomArray) {
            if (num < upperLimit) {
                System.out.println(num);
            }
        }
    }
}
