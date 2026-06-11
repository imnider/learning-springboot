package imnider.learning.springboot.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import imnider.learning.springboot.helloworld.models.User;

@Controller
public class UserController {
    @GetMapping("/profile")
    public String profile(Model model) {
        User user = new User("Neider Vélez", "neider.velez@example.com");
        model.addAttribute("user", user);
        model.addAttribute("title", "Hello World");
        return "profile";
    }
}
