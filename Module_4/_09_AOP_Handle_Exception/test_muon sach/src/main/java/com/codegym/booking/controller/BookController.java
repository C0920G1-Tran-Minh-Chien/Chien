package com.codegym.booking.controller;

import com.codegym.booking.model.Book;
import com.codegym.booking.service.BookService;
import com.codegym.booking.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    OrderBookService orderBookService;
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ModelAndView listBooks(){
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
