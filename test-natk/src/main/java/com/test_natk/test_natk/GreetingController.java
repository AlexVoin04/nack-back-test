package com.test_natk.test_natk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.GreetingService;

@RestController
public class GreetingController {

    private final GreetingService service = new GreetingService();

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return service.hello(name);
    }
}
