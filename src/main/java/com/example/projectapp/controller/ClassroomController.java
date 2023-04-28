package com.example.projectapp.controller;

import com.example.projectapp.service.ClassroomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/classes/")
public class ClassroomController {

    public ClassroomService classroomService;

    @GetMapping(path = "/hello-world/")
    public String helloWorld() {
        return "Hello World! Or should I say...\n HELLO EDGAR";
    }
}
