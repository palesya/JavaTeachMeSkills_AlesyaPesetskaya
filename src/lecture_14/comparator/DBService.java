package lecture_14.comparator;

public interface DBService<T, U> {

    void save(T entity);

    void delete(T entity);

    T get(U entity);

    T update(T entity);

}
