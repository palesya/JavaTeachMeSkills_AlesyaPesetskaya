package lecture_14.ierarchy;

public interface DBService<T> {

    void save(T entity);

    void delete(T entity);

    T get();

    T update(T entity);

}
