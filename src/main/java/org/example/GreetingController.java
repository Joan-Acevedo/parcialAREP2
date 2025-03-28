package org.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/collatzsequence")
    public Greeting mathServie(@RequestParam(value = "value") String value) {
        // aca se deberia llamar la funcionalidad de MathService
        return new Greeting(counter.incrementAndGet(), String.format(template, value));
    }
}

