package com.casestudy.controller;

import com.casestudy.model.Customer;
import com.casestudy.model.Employee;
import com.casestudy.model.Service;
import com.casestudy.service.service.RentTypeService;
import com.casestudy.service.service.ServiceService;
import com.casestudy.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ServiceController  {
    @Autowired
    ServiceTypeService serviceTypeService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    RentTypeService rentTypeService;

    @GetMapping("/service")
    public String getAllCustomer(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> searchNameService,
                                 Model model, RedirectAttributes redirectAttributes){
        String stringAfterCheck = "";
        if (!searchNameService.isPresent()){
            model.addAttribute("serviceList", serviceService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameService.get();
            model.addAttribute("serviceList", serviceService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/service/service_list";
    }
    @GetMapping("/service/create")
    public String goCreateCustomer(Service service, Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "service/create";
    }
    @PostMapping("/service/create")
    public String createCustomer(@Valid @ModelAttribute Service service,BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
//        if (bindingResult.hasErrors()){
//            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
//            model.addAttribute("rentTypeList", rentTypeService.findAll());
//            return "/service/create";
//        } else {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Created successfully!");
        return "redirect:/service";
//        }
    }
    @PostMapping(value = "/service/actionDelete/{id}")
    public String deleteService(@ModelAttribute("service") Service service, Pageable pageable, Model model) {
        serviceService.delete(service.getId());
        Page<Service> serviceList = serviceService.findAll(pageable);
        model.addAttribute("serviceList", serviceList);
        return "service/searchTable";
    }

    @GetMapping("/service/delete/{id}")
    public String deleteEmployee(@PathVariable int id, Model model) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        return "/service/delete";
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
    @GetMapping("/service/view/{id}")
    public String detailEmployee(@PathVariable int id, Model model) {
        model.addAttribute("service", serviceService.findById(id));
        return "/service/view";
    }
}
