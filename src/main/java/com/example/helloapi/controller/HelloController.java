package com.example.helloapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloapi.LogExecution;


@RestController
@RequestMapping("/api")
public class HelloController {
    @LogExecution
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World this is springboot with AOP!";
    }

    @GetMapping("/plain")
    public String noLogMethod() {
        return "Hello, World this is springboot with AOP without LOGGING !";
    }

    @GetMapping("/fail")
    public String causeError() {
       throw new RuntimeException("This is a simulated error.");
    }
    
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello Software engineer , " + name;
    }

    
}
