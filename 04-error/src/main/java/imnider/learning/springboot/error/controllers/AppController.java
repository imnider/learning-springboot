package imnider.learning.springboot.error.controllers;

import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.error.exceptions.UserNotFoundException;
import imnider.learning.springboot.error.models.domain.User;
import imnider.learning.springboot.error.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
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
        User user = service.getById(id);
        if(user == null){
            throw new UserNotFoundException("User doesn't exist");
        }
        System.out.println(user.getLastname());
        return user;
    }

}
