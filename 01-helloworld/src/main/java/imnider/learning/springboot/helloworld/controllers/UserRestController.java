package imnider.learning.springboot.helloworld.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import imnider.learning.springboot.helloworld.models.User;
import imnider.learning.springboot.helloworld.models.dto.UserDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping("/profile-map")
    public Map<String, Object> profileMap() {
        User user = new User("Neider Vélez", "neider.velez@example.com");
        Map<String, Object> response = new HashMap<>();
        response.put("title", "Hello World");
        response.put("user", user);
        return response;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        User user1 = new User("Neider Vélez", "neider.velez@example.com");
        User user2 = new User("John Doe", "john.doe@example.com");
        return List.of(user1, user2);
    }

    @GetMapping("/profile")
    public UserDto profile() {
        User user = new User("Neider Vélez", "neider.velez@example.com");
        UserDto userDto = new UserDto(user, "Hello World");
        
        return userDto;
    }
}
