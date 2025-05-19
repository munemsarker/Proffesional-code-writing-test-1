// File Name: StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error: No command-line argument provided. Please enter a valid argument.");
            return;
        }

        //show all students
        if (args[0].equals("a")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String data = reader.readLine();
                String[] students = data.split(",");
                for (String student : students) {
                    System.out.println(student.trim());
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        //show random student
        } else if (args[0].equals("r")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String data = reader.readLine();
                String[] students = data.split(",");
                Random random = new Random();
                int randomIndex = random.nextInt(students.length);
                System.out.println(students[randomIndex].trim());
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        //Add a student
        } else if (args[0].contains("+")) {
            System.out.println("Loading data...");
            try {
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("students.txt", true)
                );
                String studentToAdd = args[0].substring(1);
                Date date = new Date();
                String dateFormat = "dd/MM/yyyy-hh:mm:ss a";
                DateFormat formatter = new SimpleDateFormat(dateFormat);
                String formattedDate = formatter.format(date);
                writer.write(", " + studentToAdd + "\nList last updated on " + formattedDate);
                writer.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        //Search for a student
        } else if (args[0].contains("?")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String data = reader.readLine();
                String[] students = data.split(",");
                boolean found = false;
                String searchTerm = args[0].substring(1);
                for (int i = 0; i < students.length && !found; i++) {
                    if (students[i].trim().equals(searchTerm)) {
                        System.out.println("We found it!");
                        found = true;
                    }
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        //count words
        } else if (args[0].equals("c")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String data = reader.readLine();
                String[] students = data.split(",");
                System.out.println(students.length + " word(s) found");
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }
        }
    }
}
