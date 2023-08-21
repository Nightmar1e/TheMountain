package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Student {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(Student.class.getResourceAsStream("/students.csv"))))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                for (String index : row) {
                    System.out.printf("%10s", index);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;

// class Student {
//     private String name;
//     private int age;
//     private String country;

//     public Student(String name, int age, String country) {
//         this.name = name;
//         this.age = age;
//         this.country = country;
//     }

//     public String getName() {
//         return name;
//     }

//     public int getAge() {
//         return age;
//     }

//     public String getCountry() {
//         return country;
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         List<Student> students = new ArrayList<>();
//         String csvFilePath = "/students.csv";

//         try (InputStream inputStream = Main.class.getResourceAsStream(csvFilePath);
//              BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

//                 reader.readLine();

//                 String line;
//                 while ((line = reader.readLine()) != null) {
//                     String[] data = line.split(",");
//                     students.add(new Student(data[0], Integer.parseInt(data[1]), data[2]));
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
    
//             System.out.println("Student Information:");
//             for (Student student : students) {
//                 System.out.println("Name: " + student.getName());
//                 System.out.println("Age: " + student.getAge());
//                 System.out.println("Country: " + student.getCountry());
//                 System.out.println();
//             }
//         }
//     }
