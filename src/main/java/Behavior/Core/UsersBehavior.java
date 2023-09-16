package Behavior.Core;

import Behavior.Requests.UsersRequests;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UsersBehavior {
    UsersRequests usersRequests = new UsersRequests();

    public HttpResponse user() {
        HttpResponse response = usersRequests.getUsers();
        return response;
    }
}
