package imnider.learning.springboot.helloworld.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping("/profile")
    public Map<String, Object> profile() {
        Map<String, Object> response = new HashMap<>();
        response.put("title", "Hello World");
        response.put("developer", "Neider Vélez");
        return response;
    }
}
