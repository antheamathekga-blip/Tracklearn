import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.println("==================================");
        System.out.println("  TrackLearn - LMS Activity Tracker");
        System.out.println("==================================");
        
        while(true) {
            System.out.print("\nEnter student name or 'exit': ");
            String name = scanner.nextLine();
            if(name.equalsIgnoreCase("exit")) break;
            
            System.out.print("Enter activity: ");
            String activity = scanner.nextLine();
            
            System.out.print("Enter hours: ");
            double hours = scanner.nextDouble();
            scanner.nextLine(); 
            
            students.add(new Student(name, activity, hours));
            System.out.println("Progress tracked!");
        }
        
        System.out.println("\n--- All Tracked Students ---");
        for(Student s : students) {
            System.out.println(s);
        }
        scanner.close();
    }
}
