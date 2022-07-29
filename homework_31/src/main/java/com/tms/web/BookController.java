package com.tms.web;

import com.tms.model.Book;
import com.tms.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String searchBook(
            @RequestParam(name = "search_text") String text,
            Model model) throws SQLException {
        List<Book> books = bookService.getBooksByPartialMatch(text);
        model.addAttribute("books", books);
        return "book";
    }

    @PostMapping(path = "/add")
    public String addBook(@RequestParam(name = "book_name")String name,
                          @RequestParam(name = "book_author")String author) throws SQLException {
        bookService.save(new Book(name, author));
        return "redirect:/book";
    }

}
