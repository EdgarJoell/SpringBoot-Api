package com.example.projectapp.controller;

import com.example.projectapp.model.Classroom;
import com.example.projectapp.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/classrooms/")
public class ClassroomController {

    public ClassroomService classroomService;

    @Autowired
    public void setClassroomRepository(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

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

    @GetMapping(path = "/classrooms/{classroomId}/")
    public Optional<Classroom> getClassroom(@PathVariable Long classroomId) {
        return classroomService.getClassroom(classroomId);
    }

    @PutMapping(path = "/classrooms/{classroomId}")
    public Classroom updateClassroom(@PathVariable Long classroomId, @RequestBody Classroom classroomObject) {
        return classroomService.updateClassroom(classroomId, classroomObject);
    }

    @DeleteMapping(path = "/classrooms/{classroomId}")
    public void deleteClassroom(@PathVariable Long classroomId) {
        classroomService.deleteClassroom(classroomId);
    }
}
