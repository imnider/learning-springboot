package imnider.learning.springboot.aop.controllers;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.aop.services.IWelcomeService;

@RestController
@RequestMapping("api/welcome")
public class WelcomeController {
    
    private IWelcomeService welcomeService;

    public WelcomeController(IWelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }


    @GetMapping
    public ResponseEntity<?> welcome(){
        return ResponseEntity.ok(Collections.singletonMap("welcome", welcomeService.sayHello("Neider", "Hola")));
    }

}
