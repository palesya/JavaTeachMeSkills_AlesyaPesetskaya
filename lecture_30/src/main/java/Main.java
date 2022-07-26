import com.tms.model.User;
import com.tms.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context=new AnnotationConfigApplicationContext("com.tms");
        UserService service = context.getBean(UserService.class);
        service.save(new User(22,"test","hhh"));
        service.getUsers();
        System.out.println(service.count());
    }
}
