package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }



    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        String prop_value = environment.getProperty("my-custom-user");
        return "Hello "+name+" fetching value from "+prop_value;
        //return String.format("Hello %s!", name);
    }
}
