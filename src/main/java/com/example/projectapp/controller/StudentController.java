package com.example.projectapp.controller;

import com.example.projectapp.model.Student;
import com.example.projectapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/students/")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentRepository(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/students/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "/students/")
    public Student createStudent(@RequestBody Student studentObject) {
        return studentService.createStudent(studentObject);
    }

    @GetMapping(path="/students/{studentId}/")
    public Optional<Student> getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }
}
