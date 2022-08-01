package com.tms.service;

import com.tms.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {

    void save(Book book) throws SQLException;
    List<Book> getBooksByPartialMatch(String text) throws SQLException;

}
