package Behavior.Core;

import Behavior.Requests.CommentRequest;

import java.net.http.HttpResponse;

public class CommentBehavior {
    
    CommentRequest commentRequest = new CommentRequest();
    HttpResponse response;

    public HttpResponse getComment(Integer id) {
        response = commentRequest.getComment(id);
        return response;
    }

    public HttpResponse createComment(String body, Integer id) {
        response = commentRequest.createComment(body, id);
        return response;
    }
}
