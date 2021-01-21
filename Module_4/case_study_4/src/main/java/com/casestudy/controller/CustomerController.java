package com.casestudy.controller;


import com.casestudy.model.Customer;
import com.casestudy.service.CustomerService;
import com.casestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/customer")
    public String getAllCustomer(@PageableDefault(size = 6) Pageable pageable, @RequestParam Optional<String> searchNameCustomer,
                                 Model model, RedirectAttributes redirectAttributes){
        String stringAfterCheck = "";
        if (!searchNameCustomer.isPresent()){
            model.addAttribute("customerList", customerService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameCustomer.get();
            model.addAttribute("customerList", customerService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/customer/customer_list";
    }
    @GetMapping("/customer/create")
    public String goCreateCustomer(@ModelAttribute Customer customer, Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/create";
    }
    @PostMapping("/customer/create")
    public String createCustomer(Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Created successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/customer/edit/{id}")
    public String goEditCustomer(@PathVariable int id, Model model){
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }

//    @PostMapping("/customer/update")
//    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
//        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("message", "Edited successfully!");
//        return "redirect:/customer";
//    }
    @PostMapping("/customer/update")
    public String editCustomer(@ModelAttribute Customer customer, Pageable pageable, Model model){
        customerService.save(customer);
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "redirect:/customer";
    }
    @PostMapping(value = "/customer/actionDelete/{id}")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, Pageable pageable, Model model){
        customerService.delete(customer.getId());
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "customer/searchTable";
    }
//    @PostMapping(value = "/actionDelete/{id}")
//    public String delete(@PathVariable("id") int id, Pageable pageable, Model model) {
//        customerService.delete(id);
//        Page<Customer> blogList = customerService.findAll(pageable);
//        model.addAttribute("blogList", blogList);
//        return "blogs/search";
//    }
    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable int id, Model model){
               Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/delete";
//            Customer customer = customerService.findById(id);
//            if(customer != null) {
//                ModelAndView modelAndView = new ModelAndView("customer/delete");
//                modelAndView.addObject("customer", customer);
////                modelAndView.setViewName("customer/customer_list");
//                return modelAndView;
//            }
//            else {
//                ModelAndView modelAndView = new ModelAndView("");
//                return modelAndView;
//            }
    }
    @GetMapping("/customer/view/{id}")
    public String detailCustomer(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }

}
