package com.example.projectapp.controller;

import com.example.projectapp.repository.ClassRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/classes/")
public class ClassController {

    public ClassRepository classRepository;

    @GetMapping(path = "/hello-world/")
    public String helloWorld() {
        return "Hello World! Or should I say...\n HELLO EDGAR";
    }
}
