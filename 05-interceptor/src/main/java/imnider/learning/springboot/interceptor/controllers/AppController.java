package imnider.learning.springboot.interceptor.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
public class AppController {

    @GetMapping("/foo")
    public Map<String, String> foo(){
        return Collections.singletonMap("message", "Handler Foo of AppController");
    }

    @GetMapping("/bar")
    public Map<String, String> bar(){
        return Collections.singletonMap("message", "Handler Bar of AppController");
    }
}
