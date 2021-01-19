package com.codeym.controller;

import com.codeym.model.Employee;
import com.codeym.repository.DivisionRepository;
import com.codeym.repository.EducationRepository;
import com.codeym.repository.EmployeeRepository;
import com.codeym.repository.PositionRepository;
import com.codeym.service.DivisionService;
import com.codeym.service.EducationService;
import com.codeym.service.EmployeeService;
import com.codeym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private DivisionService divisionService;
    @GetMapping("/employee")
    public String getAllEmployee(@PageableDefault(value = 6) Pageable pageable, Optional<String> searchNameEmployee, Model model){
        String stringAfterCheck = "";
        if (searchNameEmployee.isPresent()){
            stringAfterCheck = searchNameEmployee.get();
            model.addAttribute("employeeList", employeeService.search(stringAfterCheck, pageable));
        } else {
            model.addAttribute("employeeList", employeeService.findAll(pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/employee/employee_list";
    }
    @GetMapping("/employee/create")
    public String goCreateEmployee(@ModelAttribute Employee employee, Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("positionList", positionService.getAllPosition());
        model.addAttribute("educationList", educationService.getAllEducation());
        model.addAttribute("divisionList", divisionService.getAllDivision());
        return "/employee/create";
    }
    @PostMapping("/employee/create")
    public String createEmployee(Employee employee, Model model, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Created successfully!");
        return "redirect:/employee";
    }
    @GetMapping("/employee/{id}/edit")
    public String goEditEmployee(@PathVariable int id, Model model){
        model.addAttribute("positionList", positionService.getAllPosition());
        model.addAttribute("educationList", educationService.getAllEducation());
        model.addAttribute("divisionList", divisionService.getAllDivision());
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/edit";
    }
    @PostMapping("/employee/edit")
    public String editEmployee(Employee employee, Model model, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Edited successfully!");
        return "redirect:/employee";
    }
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttributes){
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleted customer!");
        return "redirect:/employee";
    }
    @GetMapping("/employee/view/{id}")
    public String detailEmployee(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/view";
    }
}
