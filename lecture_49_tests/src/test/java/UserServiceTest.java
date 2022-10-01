import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void save(){
        User user = new User("test","test");
        UserService service = new UserService();
        String expected = "1";

        service.save(user);
        String result = user.getId();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSave(){
        User user = new User(null,"test");
        UserService service = new UserService();

        service.save(user);
        String result = user.getId();

        Assertions.assertNull(result);
    }

    @Test
    void testSave2(){
        User user = new User("test",null);
        UserService service = new UserService();

        service.save(user);
        String result = user.getId();

        Assertions.assertNull(result);
    }


}