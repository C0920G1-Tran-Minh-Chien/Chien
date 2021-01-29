package com.casestudy.controller;

import com.casestudy.model.Role;
import com.casestudy.model.User;
import com.casestudy.service.employee.UserService;
import com.casestudy.service.role.RoleService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @GetMapping("/hello")
    public String getIndex() {
        return "index";
    }
    @GetMapping("/")
    public String getIndex2() {
        return "index2";
    }

    @GetMapping("/403")
    public String getError(){
        return "403";
    }
}
