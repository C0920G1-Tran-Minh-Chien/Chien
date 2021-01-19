package com.codeym.controller;

import com.codeym.model.Service;
import com.codeym.service.RentTypeService;
import com.codeym.service.ServiceService;
import com.codeym.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;
    @GetMapping("/service")
    public String getAllService(@PageableDefault(value = 6) Pageable pageable, Model model, @RequestParam Optional<String> searchNameService){
        String stringAfterCheck = "";
        if (searchNameService.isPresent()){
            stringAfterCheck = searchNameService.get();
            model.addAttribute("serviceList", serviceService.search(stringAfterCheck, pageable));
        } else {
            model.addAttribute("serviceList", serviceService.findAll(pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/service/service_list";
    }
    @GetMapping("/service/create")
    public String goCreateService(Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("serviceTypeList", serviceTypeService.getAllServiceType());
        model.addAttribute("rentTypeList", rentTypeService.getAllRentType());
        return "/service/create";
    }
    @PostMapping("/service/create")
    public String CreateService(Service service, RedirectAttributes redirectAttributes){
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Created successfully!");
        return "redirect:/service";
    }
    @GetMapping("/service/{id}/edit")
    public String goEditService(@PathVariable int id, Model model){
        model.addAttribute("serviceTypeList", serviceTypeService.getAllServiceType());
        model.addAttribute("rentTypeList", rentTypeService.getAllRentType());
        model.addAttribute(serviceService.findById(id));
        return "/service/edit";
    }
    @PostMapping("/service/update")
    public String updateService(Service service, Model model, RedirectAttributes redirectAttributes){
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Edited successfully!");
        return "redirect:/service";
    }
    @GetMapping("/service/{id}/delete")
    public String deleteService(@PathVariable int id, RedirectAttributes redirectAttributes){
        serviceService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleted successfully!");
        return "redirect:/service";
    }
}
