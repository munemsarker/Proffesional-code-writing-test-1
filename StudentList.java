// File Name: StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        // Step 2: Handle missing argument
        if (args.length == 0) {
            System.out.println("Error: No command-line argument provided. Please enter a valid argument.");
            return;
        }

        // Show all students
        if (args[0].equals("a")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentDataLine = reader.readLine();
                String[] studentNames = studentDataLine.split(",");
                for (String studentName : studentNames) {
                    System.out.println(studentName.trim());
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        // Show a random student
        } else if (args[0].equals("r")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentDataLine = reader.readLine();
                String[] studentNames = studentDataLine.split(",");
                Random randomGenerator = new Random();
                int randomIndex = randomGenerator.nextInt(studentNames.length);
                System.out.println(studentNames[randomIndex].trim());
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        // Add a student
        } else if (args[0].contains("+")) {
            System.out.println("Loading data...");
            try {
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("students.txt", true)
                );
                String newStudentName = args[0].substring(1);
                Date currentDate = new Date();
                String dateFormatPattern = "dd/MM/yyyy-hh:mm:ss a";
                DateFormat dateFormatter = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormatter.format(currentDate);
                writer.write(", " + newStudentName + "\nList last updated on " + formattedDate);
                writer.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        // Search for a student
        } else if (args[0].contains("?")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentDataLine = reader.readLine();
                String[] studentNames = studentDataLine.split(",");
                boolean isFound = false;
                String searchName = args[0].substring(1);
                for (int i = 0; i < studentNames.length && !isFound; i++) {
                    if (studentNames[i].trim().equals(searchName)) {
                        System.out.println("We found it!");
                        isFound = true;
                    }
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }

        // Count words
        } else if (args[0].equals("c")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentDataLine = reader.readLine();
                String[] studentNames = studentDataLine.split(",");
                System.out.println(studentNames.length + " word(s) found");
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data.");
            }
        }
    }
}