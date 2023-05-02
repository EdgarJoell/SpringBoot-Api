package com.example.projectapp.service;

import com.example.projectapp.exception.InformationExistsException;
import com.example.projectapp.exception.InformationNotFoundException;
import com.example.projectapp.model.Student;
import com.example.projectapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student != null){
            return student;
        } else {
            throw new InformationNotFoundException("Student with id " + studentId + " does not exist.");
        }
    }

    public Student updateStudent(Long studentId, Student studentObject) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            if(student.get().getName().equals(studentObject.getName())) {
                throw new InformationExistsException("This name already exists.");
            } else {
                Student updateStudent = studentRepository.findById(studentId).get();
                updateStudent.setHouse(studentObject.getHouse());
                updateStudent.setName(studentObject.getName());
                updateStudent.setYear(studentObject.getYear());
                return studentRepository.save(updateStudent);
            }

        } else {
            throw new InformationNotFoundException("Student with id " + studentId + " does not exist.");
        }
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        if(student != null) {
            studentRepository.delete(student);
        } else {
            throw new InformationNotFoundException("Student with id " + studentId + " does not exist.");
        }
    }
}
