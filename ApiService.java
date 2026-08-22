import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private HttpClient client;

    public ApiService() {
        client = HttpClient.newHttpClient();
    }

    // Example: Fetch activity suggestion from API
    public String fetchActivity() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.boredapi.com/api/activity"))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Simple parse - get activity field
            String body = response.body();
            // Returns JSON like {"activity":"Learn how to ..."}
            if (body.contains("\"activity\"")) {
                int start = body.indexOf("\"activity\":\"") + 12;
                int end = body.indexOf("\"", start);
                return body.substring(start, end);
            }
            return "Study";
        } catch (Exception e) {
            System.out.println("API failed, using default: " + e.getMessage());
            return "Study";
        }
    }
}