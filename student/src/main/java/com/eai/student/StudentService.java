package com.eai.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> fetchStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {


        return studentRepository.save(student);
    }

}
