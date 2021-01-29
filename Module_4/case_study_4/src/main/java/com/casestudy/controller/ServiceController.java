package com.casestudy.controller;

import com.casestudy.model.Customer;
import com.casestudy.model.Service;
import com.casestudy.service.service.RentTypeService;
import com.casestudy.service.service.ServiceService;
import com.casestudy.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

}
