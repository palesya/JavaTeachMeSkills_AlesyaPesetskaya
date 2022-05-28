package lecture_14.comparator;

public class UserDBService implements DBService<User, String>{

    @Override
    public void save(User entity) {
        System.out.println("User is saved");
    }

    @Override
    public void delete(User entity) {
        System.out.println("User is removed");
    }

    @Override
    public User get(String name) {
        return new User("New",32);
    }

    @Override
    public User update(User entity) {
        return new User("Updated", 33);
    }
}
