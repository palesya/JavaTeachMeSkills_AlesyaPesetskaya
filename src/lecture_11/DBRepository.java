package lecture_11;

public interface DBRepository {
    void addUser(User User) throws DBException;
    void deleteUser(User User) throws DBException;
}
