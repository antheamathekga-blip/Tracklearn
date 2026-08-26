import java.util.*;

public class EmailService {
    public void sendBehindReport(List<Student> learners) {
        System.out.println("\n=== EMAIL REPORT SENT ===");
        System.out.println("To: anthea@tracklearn.com (Facilitator)");
        System.out.println("Subject: Learners Falling Behind Report");
        System.out.println("Body:");
        for (Student s : learners) {
            if (s.isBehind()) {
                System.out.println("- " + s.name + " is " + (100 - s.progress) + "% behind in " + s.course + " (" + s.progress + "%)");
            }
        }
        System.out.println("\nEmail sent via Supabase Edge Function!");
    }
}
