package Behavior.Requests;

import org.apache.http.HttpHeaders;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class UsersRequests {
    public final static String ACCESS_TOKEN = "2d6bb875b92d770b702247f4ccbb3a548126d96109951ae8aa2fd232a21e42fc";
    HttpClient client;
    HttpRequest request;
    public HttpResponse getUsers() {
         client = HttpClient.newHttpClient();
         request = HttpRequest.newBuilder()
                 .uri(URI.create("https://gorest.co.in/public/v2/users"))
                 .setHeader(HttpHeaders.AUTHORIZATION, "Bearer" + ACCESS_TOKEN)
                 .GET()
                .build();
         try {
             return client.send(request, HttpResponse.BodyHandlers.ofString());
         } catch(Exception e) {
             return null;
         }
    }

    public HttpResponse getUser(Integer id) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://gorest.co.in/public/v2/users/" + id))
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN)
                .GET()
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(Exception e) {
            return null;
        }
    }

    public HttpResponse createUser(String body) {

        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://gorest.co.in/public/v2/users"))
                .setHeader("Content-Type", "application/json")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN)
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(Exception e) {
            return null;
        }
    }

    public HttpResponse deleteUser(Integer id) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://gorest.co.in/public/v2/users/" + id))
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN)
                .DELETE()
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(Exception e) {
            return null;
        }
    }

    public HttpResponse updateUser(Integer id, String body) {

        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://gorest.co.in/public/v2/users/" + id))
                .setHeader("Content-Type", "application/json")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ACCESS_TOKEN)
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(Exception e) {
            return null;
        }
    }
}
