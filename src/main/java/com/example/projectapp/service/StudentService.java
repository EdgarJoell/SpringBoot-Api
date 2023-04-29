package com.example.projectapp.service;

import com.example.projectapp.exception.InformationExistsException;
import com.example.projectapp.model.Student;
import com.example.projectapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student studentObject) {
        Student student = studentRepository.findByName(studentObject.getName());
        if(student != null) {
            throw new InformationExistsException("Student with name " + student.getName() + " already exists.");
        } else {
            return studentRepository.save(studentObject);
        }
    }
}
