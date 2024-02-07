package com.example.library.controller;

import security.JwtTokenProvider;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    private JwtTokenProvider jwtTokenProvider;
    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book-form";
        }
        bookService.saveBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "update-book-form";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books/list";
    }
}