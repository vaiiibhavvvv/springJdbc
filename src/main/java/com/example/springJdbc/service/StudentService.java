package com.example.springJdbc.service;

import com.example.springJdbc.model.Student;
import com.example.springJdbc.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student student) {
        System.out.println("added");
        repo.save(student);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
