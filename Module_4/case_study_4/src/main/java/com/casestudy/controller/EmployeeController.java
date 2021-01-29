package com.casestudy.controller;

import com.casestudy.model.Employee;
import com.casestudy.model.Role;
import com.casestudy.model.User;
import com.casestudy.service.employee.*;
import com.casestudy.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    EducationService educationService;
    @Autowired
    PositionService positionService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;


    @GetMapping("/employee")
    public String getAllEmployee(@PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false) Optional<String> searchNameEmployee,
                                 Model model, RedirectAttributes redirectAttributes) {
        String stringAfterCheck = "";
        if (!searchNameEmployee.isPresent()) {
            System.out.println(employeeService.findAll(pageable));
            model.addAttribute("employeeList", employeeService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameEmployee.get();
            System.out.println(stringAfterCheck);
            model.addAttribute("employeeList", employeeService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/employee/employee_list";
    }

    @GetMapping("/employee/create")
    public String goCreateEmployee(Employee employee, Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationList", educationService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("userList", userService.findAll());
        return "employee/create";
    }

    @PostMapping("/employee/create")
    public String createEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("educationList", educationService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("userList", userService.findAll());
            return "/employee/create";
        } else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Created successfully!");
            return "redirect:/employee";
        }
    }

    @GetMapping("/employee/edit/{id}")
    public String goEditEmployee(@PathVariable int id, Model model) {
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationList", educationService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/edit";
    }

    @PostMapping("/employee/update")
    public String editEmployee(@ModelAttribute Employee employee, Pageable pageable, Model model) {
        employeeService.save(employee);
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "redirect:/employee";
    }

    @GetMapping("/employee/view/{id}")
    public String detailEmployee(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/view";
    }

    @PostMapping(value = "/employee/actionDelete/{id}")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee, Pageable pageable, Model model) {
        employeeService.delete(employee.getId());
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "employee/searchTable";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employee/delete";
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

    @GetMapping("/register")
    public String showFormRegister(Model model) {
        Iterable<Role> roles = roleService.findAll();
        model.addAttribute("user", new User());
        model.addAttribute("roles", roles);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        user.setEnabled(true);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Register successfully");
        return "redirect:/login";

    }
}
