package com.codeym.controller;

import com.codeym.model.Customer;
import com.codeym.service.CustomerService;
import com.codeym.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
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
    @GetMapping("/customer/{id}/edit")
    public String goEditCustomer(@PathVariable int id, Model model){
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }
    @PostMapping("/customer/update")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edited successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable int id, RedirectAttributes redirectAttributes){
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleted customer!");
        return "redirect:/customer";
    }
    @GetMapping("/customer/view/{id}")
    public String detailCustomer(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }

}
