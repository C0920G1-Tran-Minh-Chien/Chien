package com.codegym.giohang.controller;

import com.codegym.giohang.model.Book;
import com.codegym.giohang.model.OrderBook;
import com.codegym.giohang.service.BookService;
import com.codegym.giohang.service.CustomerService;
import com.codegym.giohang.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@SessionAttributes("cart")
public class OrderController {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderBookService orderBookService;
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("bookList", bookService.findAll());
        return "index";
    }

    @GetMapping("/book/{id}/borrow")
    public ModelAndView order(@PathVariable int id, Model model){
        Book book = bookService.findById(id);
        if (book.getAmount() == 0){
            return new ModelAndView("BookEmpty");
        }
        int random = new Random().nextInt(99999 - 10000) + 10000;
        ModelAndView modelAndView = new ModelAndView("order", "orderBook", new OrderBook());
        modelAndView.addObject("book", book);
        modelAndView.addObject("random", random);
        modelAndView.addObject("customer", customerService.findAll());

//        List<Book> bookList = new ArrayList<>();
//        bookList.add(book);
//        model.addAttribute("cart", book);
        return new ModelAndView("cart");
//        return modelAndView;
    }
    @PostMapping("/book/borrow")
    public String borrowBook(@ModelAttribute OrderBook orderBook){
        orderBookService.save(orderBook);
        orderBook.getBook().setAmount(orderBook.getBook().getAmount()-1);
        bookService.save(orderBook.getBook());
        return "redirect:/";
    }
    @GetMapping("/backBook")
    public String goGiveBookBack(){
        return "backBook";
    }
    @PostMapping("/backBook")
    public String giveBookBack(@RequestParam int code, RedirectAttributes redirectAttributes){
        OrderBook orderBook = orderBookService.findByCode(code);
        if (orderBook != null){
            Book book = orderBook.getBook();
            book.setAmount(book.getAmount()+1);
            orderBook.setStatus(true);
            orderBookService.save(orderBook);
            bookService.save(book);
        } else {
            redirectAttributes.addFlashAttribute("message", "not found code borrow!");
        }
        return "redirect:/";
    }
}
