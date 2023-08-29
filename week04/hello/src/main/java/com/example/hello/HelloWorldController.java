package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/native")
    public String sayHelloNative() {
        return helloWorldService.getNativeHelloMessage();
    }

    @GetMapping("/nl")
    public String sayHelloNL() {
        return helloWorldService.getNLHelloMessage();
    }

    @GetMapping("/fr")
    public String sayHelloFR() {
        return helloWorldService.getFRHelloMessage();
    }

    @GetMapping("/ger")
    public String sayHelloGER() {
        return helloWorldService.getGERHelloMessage();
    }
}
