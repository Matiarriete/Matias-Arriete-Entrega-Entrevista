package Test;

import Behavior.Core.PostBehavior;
import Behavior.Core.UsersBehavior;
import Behavior.Data.Posts;
import Behavior.Data.User;
import Behavior.Utils;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentTest {
    UsersBehavior usersBehavior = new UsersBehavior();
    PostBehavior postBehavior = new PostBehavior();

    @Test
    public void createComment() {
        User user = new User("Mati", Utils.generateMail(4) + "@mail.com", "male", "active");
        HttpResponse responseUser = usersBehavior.postUser(user.creationString());
        User userResponse = new Gson().fromJson(responseUser.body().toString(), User.class);

        assertEquals(201, responseUser.statusCode(), "Checking if user was created");

        Integer idUser = userResponse.getId();

        Posts post = new Posts(idUser, "Adultus contego subseco tener.", 
                "Adinventitias collum vereor. Atrox crustulum auctus. Nostrum sum caecus. " +
                        "Libero alienus sol. Quo aggero dolor. Sopor apostolus vos. Vomer ventosus quisquam. " +
                        "Tergo adeo corrumpo. Adopto ocer vero. Texo id antepono. Valeo sequi viriliter.");
        
        HttpResponse responsePost = postBehavior.createPost(post.toString(), idUser);

        System.out.println(responsePost.body().toString());
        assertEquals(201, responsePost.statusCode(), "Checking if post was created");
    }

}
