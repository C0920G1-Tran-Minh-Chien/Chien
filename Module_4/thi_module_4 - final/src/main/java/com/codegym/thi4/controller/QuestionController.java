package com.codegym.thi4.controller;

import com.codegym.thi4.model.Question;
import com.codegym.thi4.service.customer.QuestionService;
import com.codegym.thi4.service.customer.QuestionTypeService;
import com.codegym.thi4.service.customer.UserService;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionTypeService questionTypeService;

    @Autowired
    private UserService userService;

    @GetMapping("/question")
    public String getAllCustomer(@PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> searchNameCustomer,
                                 Model model, RedirectAttributes redirectAttributes) {
        String stringAfterCheck = "";
        if (!searchNameCustomer.isPresent()) {
            model.addAttribute("questionList", questionService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameCustomer.get();
            model.addAttribute("questionList", questionService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/question/question_list";
    }

    @GetMapping("/question/create")
    public String goCreateCustomer(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        model.addAttribute("userList", userService.findAll());
        return "question/create";
    }

    @PostMapping("/question/create")
    public String createCustomer(@Valid @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new Question().validate(question, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            model.addAttribute("userList", userService.findAll());

            return "/question/create";
        } else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Created successfully!");
            return "redirect:/question";
        }
    }

    @GetMapping("/question/edit/{id}")
    public String goEditCustomer(@PathVariable int id, Model model) {
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("question", questionService.findById(id));
        return "/question/edit";
    }


    @PostMapping("/question/update")
    public String editCustomer(@Valid @ModelAttribute Question question, BindingResult bindingResult, Pageable pageable, Model model) {
        new Question().validate(question, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            model.addAttribute("userList", userService.findAll());
            return "/question/edit";
        } else {
            questionService.save(question);
            Page<Question> customerList = questionService.findAll(pageable);
            model.addAttribute("questionList", customerList);
            return "redirect:/question";
        }
    }

    @PostMapping(value = "/question/actionDelete/{id}")
    public String deleteCustomer(@ModelAttribute("question") Question question, Pageable pageable, Model model) {
        questionService.delete(question.getId());
        Page<Question> customerList = questionService.findAll(pageable);
        model.addAttribute("questionList", customerList);
        return "question/searchTable";

    }

    @GetMapping("/question/delete/{id}")
    public String deleteCustomer(@PathVariable int id, Model model) {
        Question question = questionService.findById(id);
        model.addAttribute("question", question);
        return "/question/delete";

    }

    @GetMapping("/question/view/{id}")
    public String detailCustomer(@PathVariable int id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        return "/question/view";
    }

}
