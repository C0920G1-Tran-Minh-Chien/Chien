package testspring.demo_create_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping(value = "/hella")
    public String hello(){
        return "hello";
    }
}
