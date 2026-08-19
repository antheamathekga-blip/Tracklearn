import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = loadStudents(); // Load data from file on startup
        
        System.out.println("==================================");
        System.out.println(" TrackLearn - LMS Activity Tracker");
        System.out.println("==================================");
        
        while (true) {
            System.out.print("\nEnter student name or 'exit': ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            
            System.out.print("Enter activity: ");
            String activity = scanner.nextLine();
            
            System.out.print("Enter hours studied: ");
            double hours = scanner.nextDouble();
            scanner.nextLine(); // clear the enter key
            
            students.add(new Student(name, activity, hours));
            saveStudents(students); // Save to file after each new student
            System.out.println("Student added and saved!");
        }
        
        System.out.println("\n--- All Students ---");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("Data saved to students.txt");
        scanner.close();
    }
    
    // Save all students to students.txt
    public static void saveStudents(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                writer.println(s.getName() + "," + s.getActivity() + "," + s.getHours());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    
    // Load students from students.txt
    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("students.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                if (data.length == 3) {
                    students.add(new Student(data[0], data[1], Double.parseDouble(data[2])));
                }
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet on first run - that's fine
        }
        return students;
    }
}
