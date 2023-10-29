package RIO.example;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

import static RIO.example.Utils.EXTENSION;
import static RIO.example.Utils.START_URL;

public class HttpWLogResponse {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();

        // створюємо запит
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(START_URL + 2000 + EXTENSION))
                //.header("User-Agent", "My User Agent") // додаємо заголовок User-Agent
                //.header("Host", "example.com") // додаємо заголовок Host з яким не працює
                .build();

        try {
            // виводимо інформацію про структуру запиту
            System.out.println("HTTP-запит:"+ request.toString());
            System.out.println("Протокол HTTP для запиту: " + request.version());
            //System.out.println("Протокол HTTP для запиту: " + request.version().orElse(HttpClient.Version.HTTP_1_1));
            System.out.println("Метод: " + request.method());
            System.out.println("URI: " + request.uri());
            System.out.println("Заголовки:");
            request.headers().map().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Статус відповіді: " + response.statusCode());// вивести статус відповіді
            //System.out.println("Текст відповіді: " + response.previousResponse());// вивести статус відповіді
            System.out.println("Протокол HTTP для відповіді: " + response.version());


            // вивести заголовки відповіді
            System.out.println("Заголовки відповіді:");
            response.headers().map().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

            // вивести тіло відповіді
            System.out.println("Тіло відповіді:");
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}



