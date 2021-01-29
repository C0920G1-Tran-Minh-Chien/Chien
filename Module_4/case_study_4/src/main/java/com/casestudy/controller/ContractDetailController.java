package com.casestudy.controller;

import com.casestudy.model.Contract;
import com.casestudy.model.ContractDetail;
import com.casestudy.model.Employee;
import com.casestudy.service.Contract.AttachService;
import com.casestudy.service.Contract.ContractDetailService;
import com.casestudy.service.Contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachService attachService;

    @GetMapping("/contractDetail")
    public String getAllContract(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> searchNameContract,
                                 Model model, RedirectAttributes redirectAttributes){
        String stringAfterCheck = "";
        if (!searchNameContract.isPresent()){
            model.addAttribute("contractDetailList", contractDetailService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameContract.get();
            model.addAttribute("contractDetailList", contractDetailService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/contractDetail/contractDetail_list";
    }
    @GetMapping("/contractDetail/create")
    public String goCreateContractDetail(@ModelAttribute ContractDetail contractDetail, Model model){
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractList", contractService.getAllContract());
        model.addAttribute("attachServiceList", attachService.findAll());
        return "contractDetail/create";
    }

    @PostMapping("/contractDetail/create")
    public String createContractDetail(ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Created successfully!");
        return "redirect:/contractDetail";
    }
}
