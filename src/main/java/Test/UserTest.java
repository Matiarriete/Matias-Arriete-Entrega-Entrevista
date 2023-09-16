package Test;

import Behavior.Core.UsersBehavior;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    UsersBehavior userbehavior = new UsersBehavior();

    @Test
    public void getUser() {
        System.out.println("Ebtri");
        assertEquals(userbehavior.user().statusCode(), 200);
        System.out.println(userbehavior.user().body());
    }
}
