package imnider.learning.springboot.helloworld.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.helloworld.models.dto.ParamDto;
import imnider.learning.springboot.helloworld.models.dto.UserDto;

@RestController
@RequestMapping("/api/path")
public class PathVariableController {
    @Value("${config.code}")
    private Integer configCode;

    @Value("${config.list}")
    private List<String> languagesListDefault;

    @Value("#{ '${config.list}'.toUpperCase().split(',') }")
    private List<String> languagesList;

    @Value("#{ '${config.list}' }")
    private String languagesListString;

    @Value("#{${config.valuesMap}}")
    private Map<String, String> valuesMap;

    @Value("#{${config.valuesMap}.name}")
    private String userName;

    @Value("#{${config.valuesMap}.email}")
    private String userEmail;

    @Autowired
    Environment environment;

    @GetMapping("/foo/{code}")
    public ParamDto foo(@PathVariable Integer code) {
        return new ParamDto(code.toString(), code);
    }

    @GetMapping("/bar/{message}/{code}")
    public ParamDto bar(@PathVariable String message, @PathVariable Integer code) {
        return new ParamDto(message, code);
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userDto;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String configMessage) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", configCode);
        response.put("envCode", environment.getProperty("config.code", Integer.class));
        response.put("message", configMessage);
        response.put("envMessage", environment.getProperty("config.message", String.class));
        response.put("languagesDefault", languagesListDefault);
        response.put("envLanguagesDefault", environment.getProperty("config.list", List.class));
        response.put("languagesList", languagesList);
        response.put("languagesListString", languagesListString);
        response.put("valuesMap", valuesMap);
        response.put("userName", userName);
        response.put("userEmail", userEmail);
        return response;
    }
}
