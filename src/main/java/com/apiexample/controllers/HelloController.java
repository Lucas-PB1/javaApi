package com.apiexample.controllers;

import com.apiexample.models.Hello;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Hello hello(@RequestParam(value = "name", defaultValue = "Word") String name){
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }
}
