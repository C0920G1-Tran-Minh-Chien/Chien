package vn.codegym.thuchanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.thuchanh.model.User;

@Controller
public class UserController {

    @GetMapping("/user")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("views/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("views/index");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("views/result");
            return modelAndView;
        }
    }
}
