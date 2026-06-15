package imnider.learning.springboot.error.controllers;

import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.error.exceptions.UserNotFoundException;
import imnider.learning.springboot.error.models.domain.User;
import imnider.learning.springboot.error.services.IUserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/app")
public class AppController {

    IUserService service;
    public AppController(@Autowired IUserService service){
        this.service = service;
    }

    @GetMapping()
    public String app() {
        // int value = 100 / 0;
        int value = Integer.parseInt("duck");
        return "Ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id){
        User user = service.getById(id).orElseThrow(() -> new UserNotFoundException("User doesn't exist"));
        System.out.println(user.getLastname());
        return user;
    }

    @GetMapping("/response/{id}")
    public ResponseEntity<?> showResponse(@PathVariable Long id){
        Optional<User> optionalUser = service.getById(id);
        if(optionalUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUser.orElseThrow());
    }

}
