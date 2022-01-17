package com.keum.demo.controller;

import com.keum.demo.domain.Book;
import com.keum.demo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("/books")
public class BookController {
    private BookRepository bookRepository = BookRepository.getBookRepository();

        @GetMapping("/new-form")
        public String newForm() {
            return "new-form";
        }

        @PostMapping("/save")
        public String save(@RequestParam("bookname") String bookname, @RequestParam("publisher") String publisher,
                           @RequestParam("price") int price, Model model) {
            Book book = new Book(bookname, publisher, price);
            bookRepository.save(book);
            model.addAttribute("book", book);
            return "save-result";
        }

        @GetMapping
        public String books(Model model) {
            List<Book> books = bookRepository.findAll();
            model.addAttribute("books", books);
            return "books";
        }
}
