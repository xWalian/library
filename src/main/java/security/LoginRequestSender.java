package security;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginRequestSender {

    public static void main(String[] args) {
        // Dane logowania (nazwa użytkownika i hasło)
        String username = "root";
        String password = "root";

        // Tworzenie obiektu HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Adres URL endpointu logowania
        String loginUrl = "http://localhost:8080/login"; // Zastąp adresem swoim właściwym adresem URL

        // Tworzenie danych do wysłania w ciele żądania
        Map<Object, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);

        // Wysłanie żądania logowania
        try {
            String response = sendLoginRequest(httpClient, loginUrl, data);
            System.out.println("Response: " + response);
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static String sendLoginRequest(HttpClient httpClient, String loginUrl, Map<Object, Object> data) throws IOException, InterruptedException, URISyntaxException {
        // Tworzenie żądania POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(loginUrl))
                .header("Content-Type", "application/json")
                .POST(buildJsonFromMap(data))
                .build();

        // Wysłanie żądania i odbiór odpowiedzi
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Zwrócenie odpowiedzi jako string
        return response.body();
    }

    private static HttpRequest.BodyPublisher buildJsonFromMap(Map<Object, Object> data) {
        // Konwersja mapy na format JSON
        String json = "{";
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            json += "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\",";
        }
        json = json.substring(0, json.length() - 1); // Usunięcie ostatniej przecinki
        json += "}";
        return HttpRequest.BodyPublishers.ofString(json);
    }
}
