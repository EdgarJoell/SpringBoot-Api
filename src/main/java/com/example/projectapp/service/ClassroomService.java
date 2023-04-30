package com.example.projectapp.service;

import com.example.projectapp.exception.InformationExistsException;
import com.example.projectapp.model.Classroom;
import com.example.projectapp.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
