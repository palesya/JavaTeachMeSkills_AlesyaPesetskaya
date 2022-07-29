package com.tms.service.impl;

import com.tms.exception.SaveBookException;
import com.tms.model.Book;
import com.tms.repository.impl.BookRepositoryImpl;
import com.tms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryImpl bookRepository;

    @Override
    public void save(Book book) throws SQLException {
        List<Book> allSavedBooks = bookRepository.getAllBooks();
        for (Book savedBook : allSavedBooks) {
            if (book.getName().equalsIgnoreCase(savedBook.getName()) && book.getAuthor().equalsIgnoreCase(savedBook.getAuthor())) {
                throw new SaveBookException("Such book with name " + book.getName() +
                        " and author " + book.getAuthor() + " already exists");

            }
        }
        if (!book.getName().isBlank() && !book.getAuthor().isBlank()) {
            bookRepository.save(book);
        }
    }

    @Override
    public List<Book> getAll() throws SQLException {
        return bookRepository.getAllBooks();
    }

    @Override
    public List<Book> getBooksByPartialMatch(String text) throws SQLException {
        return bookRepository.getBooksByPartialMatch(text);
    }
}
