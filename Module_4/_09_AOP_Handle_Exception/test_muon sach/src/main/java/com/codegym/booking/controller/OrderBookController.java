package com.codegym.booking.controller;

import com.codegym.booking.model.Book;
import com.codegym.booking.model.Customer;
import com.codegym.booking.model.OrderBook;
import com.codegym.booking.service.BookService;
import com.codegym.booking.service.CustomerService;
import com.codegym.booking.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Random;

@Controller
public class OrderBookController {

    @Autowired
    OrderBookService orderBookService;
    @Autowired
    BookService bookService;
    @Autowired
    CustomerService customerService;
    @ModelAttribute("customers")
    public Iterable<Customer> customers() {return customerService.findAll();}

    @ModelAttribute("books")
    public Iterable<Book> books() {return bookService.findAll();}

    @GetMapping("/orders")
    public ModelAndView listOrderBook(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<OrderBook> orderBookPage;
        orderBookPage = orderBookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("orderBook/list");
        modelAndView.addObject("orderBookPage", orderBookPage);
        return modelAndView;
    }

    @GetMapping("/create-orderBook")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("orderBook/create");
        modelAndView.addObject("orderBook", new OrderBook());
        return modelAndView;
    }

    @PostMapping("/create-orderBook")
    public ModelAndView saveOrderBook(@ModelAttribute("orderBook") OrderBook orderBook){
        orderBook.setId(1);
        orderBookService.save(orderBook);
        ModelAndView modelAndView = new ModelAndView("orderBook/create");
        modelAndView.addObject("orderBook", new OrderBook());
        modelAndView.addObject("message", "New customer created successfully");
        orderBook.getBook().setAmount(orderBook.getBook().getAmount()-1);
        bookService.save(orderBook.getBook());
        return modelAndView;
    }

//    @GetMapping("/book/{id}/amount")
//    public ModelAndView amount(@PathVariable int id){
//        Book book = bookService.findById(id);
//        if (book == null){
//            return new ModelAndView("book/list");
//        }
//        int random = new Random().nextInt(99999 - 10000) + 10000;
//        ModelAndView modelAndView = new ModelAndView("orderBook/create", "orderBook", new OrderBook());
//        modelAndView.addObject("book", book);
//        modelAndView.addObject("random", random);
//        modelAndView.addObject("student", studentService.getAllStudent());
//
//        return modelAndView;
//    }
//    @PostMapping("/create-orderBook")
//    public String borrowBook(@ModelAttribute OrderBook orderBook){
//        orderBookService.save(orderBook);
//        orderBook.getBook().setAmount(orderBook.getBook().getAmount()-1);
//        bookService.save(orderBook.getBook());
//        return "redirect:/";
//    }
//    @GetMapping("/book/give_book_back")
//    public String goGiveBookBack(){
//        return "give-book-back";
//    }
//    @PostMapping("/book/give_book_back")
//    public String giveBookBack(@RequestParam int codeborrow, RedirectAttributes redirectAttributes){
//        CardStudentBook cardStudentBook = cardStudentBookService.findByCodeborrow(codeborrow);
//        if (cardStudentBook != null){
//            Book book = cardStudentBook.getBook();
//            book.setAmount(book.getAmount()+1);
//            cardStudentBook.setStatus(true);
//            cardStudentBookService.save(cardStudentBook);
//            bookService.save(book);
//        } else {
//            redirectAttributes.addFlashAttribute("message", "not found code borrow!");
//        }
//        return "redirect:/";
//    }
}
