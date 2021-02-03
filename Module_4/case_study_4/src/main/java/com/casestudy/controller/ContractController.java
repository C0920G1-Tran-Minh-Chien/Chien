package com.casestudy.controller;

import com.casestudy.model.Contract;
import com.casestudy.model.Employee;
import com.casestudy.service.Contract.AttachService;
import com.casestudy.service.Contract.ContractDetailService;
import com.casestudy.service.Contract.ContractService;
import com.casestudy.service.customer.CustomerService;
import com.casestudy.service.employee.EmployeeService;
import com.casestudy.service.service.ServiceService;
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
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    AttachService attachService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;

    @GetMapping("/contract")
    public String getAllContract(@PageableDefault(size = 6) Pageable pageable, @RequestParam Optional<String> searchNameContract,
                                 Model model, RedirectAttributes redirectAttributes){
        String stringAfterCheck = "";
        if (!searchNameContract.isPresent()){
            model.addAttribute("contractList", contractService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameContract.get();
            model.addAttribute("contractList", contractService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/contract/contract_list";
    }
    @GetMapping("/contract/create")
    public String goCreateEmployee(Contract contract, Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList", employeeService.getAllEmployee());
        model.addAttribute("customerList", customerService.getAllCustomer());
        model.addAttribute("serviceList", serviceService.getAllService());
        return "contract/create";
    }

    @PostMapping("/contract/create")
    public String createEmployee(@Valid  @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeList", employeeService.getAllEmployee());
            model.addAttribute("customerList", customerService.getAllCustomer());
            model.addAttribute("serviceList", serviceService.getAllService());
            return "/contract/create";
        } else {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Created successfully!");
        return "redirect:/contract";
        }
    }

    @PostMapping(value = "/contract/actionDelete/{id}")
    public String deleteEmployee(@ModelAttribute("employee") Contract contract, Pageable pageable, Model model) {
        contractService.delete(contract.getId());
        Page<Contract> contractList = contractService.findAll(pageable);
        model.addAttribute("contractList", contractList);
        return "contract/searchTable";
    }

    @GetMapping("/contract/delete/{id}")
    public String deleteEmployee(@PathVariable int id, Model model) {
        Contract contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        return "/contract/delete";
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
    @GetMapping("/contract/view/{id}")
    public String detailEmployee(@PathVariable int id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "/contract/view";
    }
}
