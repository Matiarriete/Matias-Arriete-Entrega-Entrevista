package Behavior.Core;

import Behavior.Requests.UsersRequests;

import java.net.http.HttpResponse;

public class UsersBehavior {
    private UsersRequests usersRequests = new UsersRequests();
    private HttpResponse response;

    public HttpResponse getUsers() {
        response = usersRequests.getUsers();
        return response;
    }

    public HttpResponse getUser(Integer id) {
        response = usersRequests.getUser(id);
        return response;
    }

    public HttpResponse postUser(String body) {
        response = usersRequests.createUser(body);
        return response;
    }

    public HttpResponse deleteUser(Integer id) {
        response = usersRequests.deleteUser(id);
        return response;
    }

    public HttpResponse updateUser(Integer id, String body) {
        response = usersRequests.updateUser(id, body);
        return response;
    }
}
