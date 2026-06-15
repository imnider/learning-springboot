package imnider.learning.springboot.error.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("/app")
    public String app() {
        // int value = 100 / 0;
        int value = Integer.parseInt("duck");
        return "Ok 200";
    }

}
