package com.tms.web;

import com.tms.model.Book;
import com.tms.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping
    public String get(Book book) {
        return "book";
    }

    @PostMapping
    public String searchBook(
            @RequestParam(name = "search_text") String text,
            Model model) throws SQLException {
        List<Book> books = bookService.getBooksByPartialMatch(text);
        model.addAttribute("books", books);
        model.addAttribute(new Book());
        return "book";
    }

    @PostMapping(path = "/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) throws SQLException {
        bookService.save(book);
        return "redirect:/book";
    }

}
