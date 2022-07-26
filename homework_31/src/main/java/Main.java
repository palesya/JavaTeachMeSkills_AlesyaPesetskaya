import com.tms.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=alesya");
        PreparedStatement statement = connection.prepareStatement("select * from book");
        ResultSet resultSet = statement.executeQuery();
        List<Book> books = new ArrayList<>();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            Book book = new Book(name,author);
            books.add(book);
        }
        statement.close();
        System.out.println(books);
    }
}
