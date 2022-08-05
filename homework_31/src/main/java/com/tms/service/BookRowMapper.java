package com.tms.service;

import com.tms.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String author = rs.getString("author");
        return new Book(name,author);
    }

}
