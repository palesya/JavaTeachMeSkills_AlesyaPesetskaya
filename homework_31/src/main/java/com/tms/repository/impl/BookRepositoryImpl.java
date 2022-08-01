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

    public static final String SAVE_SQL = "insert into book (id, name, author) values(?,?,?)";
    public static final String GET_ALL_SQL = "select * from book";
    public static final String GET_MAX_ID = "SELECT max(id) FROM book";
    public static final String GET_BY_NAME_AND_AUTHOR = "select * from book where LOWER(name)=LOWER(?) AND LOWER(author) = LOWER(?)";
    public static final String GET_BY_PARTIAL_MATCH = "select * from book where LOWER(name) LIKE LOWER(?) OR LOWER(author) LIKE LOWER(?)";

    @Autowired
    private Connection connection;

    @Override
    public void save(Book book) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SAVE_SQL);
        int id;
        if (getMaxID() == 0) {
            id = 1;
        } else {
            id = getMaxID() + 1;
        }
        statement.setInt(1, id);
        statement.setString(2, book.getName());
        statement.setString(3, book.getAuthor());
        statement.execute();
        statement.close();
    }

    @Override
    public List<Book> getBooksByPartialMatch(String text) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_BY_PARTIAL_MATCH);
        statement.setString(1, "%"+text+"%");
        statement.setString(2, "%"+text+"%");
        ResultSet resultSet = statement.executeQuery();
        return getBooks(resultSet, statement);
    }

    @Override
    public List<Book> getBooksByNameAndAuthor(String name, String author) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_BY_NAME_AND_AUTHOR);
        statement.setString(1, name);
        statement.setString(2, author);
        ResultSet resultSet = statement.executeQuery();
        return getBooks(resultSet, statement);
    }

    private List<Book> getBooks(ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            Book book = new Book(name, author);
            books.add(book);
        }
        preparedStatement.close();
        return books;
    }

    private int getMaxID() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_MAX_ID);
        ResultSet maxIDStatement = statement.executeQuery();
        int maxID = 0;
        if (maxIDStatement.next()) {
            maxID = maxIDStatement.getInt(1);
        }
        return maxID;
    }
}
