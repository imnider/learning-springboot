package imnider.learning.springboot.helloworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.helloworld.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "No message provided") String message) {
        return new ParamDto(message);
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam(required = false, defaultValue = "No message provided") String message,
                            @RequestParam(required = false) Integer code) {
        return new ParamDto(message, code);
    }

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        String message = request.getParameter("message");
        String codeParam = request.getParameter("code");
        Integer code = null;
        if (codeParam != null) {
            try {
                code = Integer.parseInt(codeParam);
            } catch (NumberFormatException e) {
                // Manejar el error de formato si el parámetro no es un número válido
                return new ParamDto("Invalid code format: " + codeParam);
            }
        }
        return new ParamDto(message != null ? message : "No message provided", code);
    }
}
