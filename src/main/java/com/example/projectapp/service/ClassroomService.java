package com.example.projectapp.service;

import com.example.projectapp.exception.InformationExistsException;
import com.example.projectapp.exception.InformationNotFoundException;
import com.example.projectapp.model.Classroom;
import com.example.projectapp.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private ClassroomRepository classroomRepository;

    @Autowired
    public void setClassroomRepository(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getClassrooms () {
        return classroomRepository.findAll();
    }

    public Classroom createClassroom(Classroom classroomObject) {
        Classroom classroom = classroomRepository.findByName(classroomObject.getName());
        if(classroom != null) {
            throw new InformationExistsException("A Classroom with name " + classroom.getName() + " already exists.");
        } else {
            return classroomRepository.save(classroomObject);
        }
    }

    public Optional<Classroom> getClassroom(Long classroomId) {
        Optional<Classroom> classroom = classroomRepository.findById(classroomId);
        if(classroom.isPresent()) {
            return classroom;
        } else {
            throw new InformationNotFoundException("Teacher with id " + classroomId + " does not exist.");
        }
    }

    public Classroom updateClassroom(Long classroomId, Classroom classroomObject) {
        Classroom classroom = classroomRepository.findById(classroomId).get();
        if(classroom != null) {
            classroom.setName(classroomObject.getName());
            return classroomRepository.save(classroom);
        } else {
            throw new InformationNotFoundException("Teacher with id " + classroomId + " does not exits.");
        }
    }

    public void deleteClassroom(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId).get();
        if(classroom != null) {
            classroomRepository.delete(classroom);
        } else {
            throw new InformationNotFoundException("Student with id " + classroom + " does not exist.");
        }
    }
}
