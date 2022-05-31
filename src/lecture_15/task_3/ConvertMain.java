package lecture_15.task_3;

public class ConvertMain {

    public static void main(String[] args) {

        User user = new User("hello",10);
        UserToAccConverter userToAccConverter = new UserToAccConverter();
        Account account = userToAccConverter.convert(user, ConvertMain::create);
        System.out.println(account);

    }

    static Account create(User user){
        return new Account(user.getName(), user.getId(),user.getName().toUpperCase());
    }
}
