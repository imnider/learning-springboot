package imnider.learning.springboot.helloworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.helloworld.models.dto.ParamDto;

@RestController
@RequestMapping("/api/path")
public class PathVariableController {
    @GetMapping("/foo/{code}")
    public ParamDto foo(@PathVariable Integer code) {
        return new ParamDto(code.toString(), code);
    }

    @GetMapping("/bar/{message}/{code}")
    public ParamDto bar(@PathVariable String message, @PathVariable Integer code) {
        return new ParamDto(message, code);
    }
}
