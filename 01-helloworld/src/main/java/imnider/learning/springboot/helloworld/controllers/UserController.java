package imnider.learning.springboot.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("title", "Hello World");
        return "profile";
    }
}
