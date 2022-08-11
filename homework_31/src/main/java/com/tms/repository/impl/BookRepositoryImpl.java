package com.tms.repository.impl;

import com.tms.model.Book;
import com.tms.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    public static final String SAVE_SQL = "insert into book (id, name, author) values(?,?,?)";
    public static final String GET_MAX_ID = "SELECT max(id) FROM book";
    public static final String GET_BY_NAME_AND_AUTHOR = "select * from book where LOWER(name)=LOWER(?) AND LOWER(author) = LOWER(?)";
    public static final String GET_BY_PARTIAL_MATCH = "select * from book where LOWER(name) LIKE LOWER(?) OR LOWER(author) LIKE LOWER(?)";

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> mapper;

    @Override
    public void save(Book book) throws SQLException {
        int id = getMaxID()+1;
        jdbcTemplate.update(SAVE_SQL, id, book.getName(), book.getAuthor());
    }

    @Override
    public List<Book> getBooksByPartialMatch(String text) {
        return jdbcTemplate.query(GET_BY_PARTIAL_MATCH,mapper,"%" + text + "%","%" + text + "%");
    }

    @Override
    public List<Book> getBooksByNameAndAuthor(String name, String author) {
        return jdbcTemplate.query(GET_BY_NAME_AND_AUTHOR, mapper,name,author);
    }

    private int getMaxID() throws SQLException {
        Integer maxIndexInDB = jdbcTemplate.queryForObject(GET_MAX_ID, Integer.class);
        int maxID = 0;
        if (maxIndexInDB != null) {
            maxID = maxIndexInDB;
        }
        return maxID;
    }
}
