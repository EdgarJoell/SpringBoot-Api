package com.example.projectapp.controller;

import com.example.projectapp.model.Classroom;
import com.example.projectapp.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/classrooms/")
public class ClassroomController {

    public ClassroomService classroomService;

    @GetMapping(path = "/hello-world/")
    public String helloWorld() {
        return "Hello World! Or should I say...\n HELLO EDGAR";
    }

    @GetMapping(path = "/classrooms")
    public List<Classroom> getClassrooms() {
        return classroomService.getClassrooms();
    }

    @PostMapping(path="/classrooms/")
    public Classroom createClassroom(@RequestBody Classroom classroomObject ) {
        return classroomService.createClassroom(classroomObject);
    }
}
