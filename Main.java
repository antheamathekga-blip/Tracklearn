import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== TrackLearn LMS Login ===");
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        AuthService auth = new AuthService();
        User user = auth.login(email, pass);

        if (user == null) {
            System.out.println("Login failed! Try anthea@tracklearn.com / 123456");
            return;
        }

        System.out.println("\nWelcome " + user.name + " | Role: " + user.role);

        if (user.role.equals("facilitator")) {
            // FACILITATOR - CLEAN DASHBOARD (Your new Figma, NO POPUP)
            DatabaseService db = new DatabaseService();
            List<Student> all = db.getAllLearners();

            System.out.println("\n--- DASHBOARD ---");
            System.out.println("128 Students | 12 Courses | 76% Complete | 84% Avg Score");
            System.out.println("\nAll Learners:");
            for (Student s : all) {
                System.out.println(s.name + " | " + s.course + " | " + s.progress + "% | " + (s.isBehind() ? "BEHIND" : "ON TRACK"));
            }

            // Email requirement
            EmailService emailService = new EmailService();
            emailService.sendBehindReport(all);

        } else {
            // LEARNER - POPUP ONLY IF BEHIND
            Student me = new DatabaseService().getLearnerByEmail(email);
            System.out.println("\n--- MY LEARNING ---");
            System.out.println("Course: " + me.course);
            System.out.println("Progress: " + me.progress + "%");

            if (me.isBehind()) {
                System.out.println("\n[ POPUP ] You're Falling Behind!");
                System.out.println("You're " + (100 - me.progress) + "% behind in " + me.course + ". Catch up now!");
                System.out.println("[ Continue Learning > ]");
            } else {
                System.out.println("You are on track! No popup - clean dashboard.");
            }
        }
    }
}
