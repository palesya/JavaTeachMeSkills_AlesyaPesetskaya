package lecture_11;

public class DBUserRepositoryService implements DBRepository{

    @Override
    public void addUser(User User) throws DBException{
        throw new DBException();
    }

    @Override
    public void deleteUser(User User) throws DBException{
        throw new DBException();
    }
}
