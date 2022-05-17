package lecture_11;

public class DBService {
    void save(User user) {
        try {
            throw new DBException();
        } catch (DBException exc) {
            System.out.println("can't save");
        }
    }
}
