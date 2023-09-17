package Behavior.Core;

import Behavior.Requests.PostRequest;

import java.net.http.HttpResponse;

public class PostBehavior {

    PostRequest postRequest = new PostRequest();

    public HttpResponse getPost(Integer id) {
        HttpResponse response = postRequest.getPost(id);
        return response;
    }

    public HttpResponse createPost(String body, Integer id) {
        HttpResponse response = postRequest.createPost(body, id);
        return response;
    }
}
