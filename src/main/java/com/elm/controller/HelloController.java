package com.elm.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elm/HelloController")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam("message") String message) {
        return "You submitted: " + message;
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable String id) {
        return "User ID: " + id;
    }
}



