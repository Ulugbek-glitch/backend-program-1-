package me.ugk.springdeveloper.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {


    // "/hello" 요청을 보내면 hello() 메서드 호출
    // c

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/test")
    public String getTest() { return "Get Test Response";}

    @PostMapping("/test")
    public String postTest() {
        return "Post Test Response";
    }

    @DeleteMapping("/test")
    public String deleteTest() {
        return "Delete Test Response";
    }
    @PutMapping("/test")
    public String putTest() {
        return "Put Test Response";
    }
}
