package Test;

import Behavior.Core.UsersBehavior;
import Behavior.Data.User;
import Behavior.Utils;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    UsersBehavior userbehavior = new UsersBehavior();

    @Test
    public void getUsers() {
        assertEquals(userbehavior.getUsers().statusCode(), 200);
    }

    @Test
    public void getUser() {
        assertEquals(200, userbehavior.getUser(5169687).statusCode(), "Verifying user exists");
    }

    @Test
    public void createUser() {
        User user = new User("Mati", Utils.generateMail(4) + "@mail.com", "male", "active");
        HttpResponse response = userbehavior.postUser(user.creationString());
        User userResponse = new Gson().fromJson(response.body().toString(), User.class);

        assertEquals(201, response.statusCode(), "Checking if user was created");

        Integer idResponse = userResponse.getId();
        HttpResponse responseGet = userbehavior.getUser(idResponse);

        assertEquals(200, responseGet.statusCode(), "Verifying that user was created");
    }

    @Test
    public void deleteUser() {

        User user = new User("Mati", Utils.generateMail(4) + "@mail.com", "male", "active");
        HttpResponse response = userbehavior.postUser(user.creationString());
        User userResponse = new Gson().fromJson(response.body().toString(), User.class);

        assertEquals(201, response.statusCode(), "Checking if user was created");

        Integer idResponse = userResponse.getId();

        HttpResponse responseDeleted = userbehavior.deleteUser(idResponse);
        assertEquals(204, responseDeleted.statusCode(),  "Checking the user was deleted");

        HttpResponse responseGet = userbehavior.getUser(idResponse);
        assertEquals(404, responseGet.statusCode(), "Verifying that user was deleted");
    }

    //Ver update
    @Test
    public void updateUser() {
        User user = new User("Mati", Utils.generateMail(4) + "@mail.com", "male", "active");

        HttpResponse response = userbehavior.postUser(user.creationString());
        User userResponse = new Gson().fromJson(response.body().toString(), User.class);

        assertEquals(201, response.statusCode(), "Checking if user was created");

        Integer idResponse = userResponse.getId();
        HttpResponse responseGet = userbehavior.getUser(idResponse);

        assertEquals(200, responseGet.statusCode(), "Verifying that user was created");

        String emailUpdate = Utils.generateMail(4) + "@mail.com";

        HttpResponse responseUpdate = userbehavior.updateUser(idResponse, "{\"mail\": \"" + emailUpdate + "\"}");

        assertEquals(200, responseUpdate.statusCode(), "Checking user was modified");

        responseGet = userbehavior.getUser(idResponse);
        User userUpdated = new Gson().fromJson(responseGet.body().toString(), User.class);

        assertEquals(emailUpdate, userUpdated.getEmail(),  "Verifying that user was created");

    }


}
