package Behavior.Requests;

import org.apache.http.HttpHeaders;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CommentRequest {

    public final static String ACCESS_TOKEN = "2d6bb875b92d770b702247f4ccbb3a548126d96109951ae8aa2fd232a21e42fc";
    HttpClient client;
    HttpRequest request;

    public HttpResponse getComment(Integer id) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://gorest.co.in/public/v2/posts/" + id + "/comments"))
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN)
                .GET()
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(Exception e) {
            return null;
        }
    }

    public HttpResponse createComment(String body, Integer id) {

        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://gorest.co.in/public/v2/posts/" + id + "/comments"))
                .setHeader("Content-Type", "application/json")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(Exception e) {
            return null;
        }
    }

}
