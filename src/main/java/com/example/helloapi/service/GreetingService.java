package com.example.helloapi.service;

public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name;
    }

    public String greetWithError(String name) {
        if (name.equalsIgnoreCase("error")) {
            throw new RuntimeException("Simulated service error!");
        }
        return "Hi, " + name;
    }

}
