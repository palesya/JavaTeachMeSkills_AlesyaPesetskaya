package com.tms.web;

import com.tms.model.Book;
import com.tms.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping
    public String get() {
        return "book";
    }

    @PostMapping
    public String searchBook(HttpServletRequest req) throws SQLException {
        String text = req.getParameter("search_text");
        req.setAttribute("text", text);
        List<Book> books = bookService.getBooksByPartialMatch(text);
        req.setAttribute("books", books);
        return "book";
    }

    @PostMapping(path = "/add")
    public String addBook(HttpServletRequest req) throws SQLException {
        String name = req.getParameter("book_name");
        String author = req.getParameter("book_author");
        bookService.save(new Book(name,author));
        return "redirect:/book";
    }

}
