package lecture_15.task_3;

import java.util.function.Function;

public class UserToAccConverter {

    Account convert(User user, Function<User, Account> convert){
        return convert.apply(user);
    }
}
