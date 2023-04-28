package com.example.projectapp.service;

import com.example.projectapp.model.Student;
import com.example.projectapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
