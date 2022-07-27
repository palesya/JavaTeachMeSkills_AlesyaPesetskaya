package com.tms.repository;

import com.tms.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {

    void save(Book book) throws SQLException;
    List<Book> getAllBooks() throws SQLException;
    List<Book> getBooksByPartialMatch(String text) throws SQLException;
}
