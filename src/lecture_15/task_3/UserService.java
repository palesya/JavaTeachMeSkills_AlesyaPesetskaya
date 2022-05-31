package lecture_15.task_3;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserService {

    void processUser(User user, Predicate<User> valid, Consumer<User> process){
        if (valid.test(user)){
            process.accept(user);
        }else{
            System.out.println("User is not valid!");
        }
    }

}
