package imnider.learning.springboot.helloworld.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @GetMapping("/users")
    public String users(ModelMap model) {
        model.addAttribute("title", "User List");
        return "users";
    }

    // Métodos
    @ModelAttribute("users")
    public List<User> users() {
        return List.of(
            new User("Neider Vélez", "neider.velez@example.com", "I'm a software developer with experience in Java and Spring Boot."),
            new User("John Doe", "john.doe@example.com", "I'm a marketing specialist.")
        );
    }
}
