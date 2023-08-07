package az.ingress.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/test")
    public String getResponse() {
        return "Kamil";
    }

    @GetMapping("/ms18/{name}")
    public String getName(@PathVariable String name) {
        return name;
    }

    @GetMapping("/ms18-2/{name}")
    public String getName2(@PathVariable("name") String test) {
        return test;
    }
}
