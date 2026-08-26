import java.util.*;

public class AuthService {
    // Simulates Supabase users table
    private Map<String, User> users = new HashMap<>();
    private Map<String, String> passwords = new HashMap<>();

    public AuthService() {
        users.put("anthea@tracklearn.com", new User(1, "Anthea Mathekga", "anthea@tracklearn.com", "facilitator", "AM"));
        users.put("banele@tracklearn.com", new User(2, "Banele", "banele@tracklearn.com", "learner", "BM"));
        users.put("siviwe@tracklearn.com", new User(3, "Siviwe", "siviwe@tracklearn.com", "learner", "SN"));
        users.put("osamar@tracklearn.com", new User(4, "Osamar", "osamar@tracklearn.com", "learner", "OA"));
        
        passwords.put("anthea@tracklearn.com", "123456");
        passwords.put("banele@tracklearn.com", "123456");
        passwords.put("siviwe@tracklearn.com", "123456");
        passwords.put("osamar@tracklearn.com", "123456");
    }

    public User login(String email, String password) {
        if (users.containsKey(email) && passwords.get(email).equals(password)) {
            return users.get(email);
        }
        return null;
    }
}
