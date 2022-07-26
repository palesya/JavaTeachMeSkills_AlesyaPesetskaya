package com.tms.repository.impl;

import com.tms.model.Book;
import com.tms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookRepositoryImpl implements BookRepository {

    public static final String SAVE_SQL = "insert into book (name, password) values(?,?)";
    public static final String GET_ALL_SQL = "select * from book";

   @Autowired
    private Connection connection;

    @Override
    public void save(Book book) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SAVE_SQL);
        statement.setString(1, book.getName());
        statement.setString(2,book.getAuthor());
        statement.execute();
        statement.close();
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_ALL_SQL);
        ResultSet resultSet = statement.executeQuery();
        return getBooks(resultSet,statement);
    }

    private List<Book> getBooks(ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            Book book = new Book(name,author);
            books.add(book);
        }
        preparedStatement.close();
        return books;
    }
}
