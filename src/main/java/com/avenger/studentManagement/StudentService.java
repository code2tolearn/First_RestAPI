package com.avenger.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository ;



    // Processing Logic
    public String addStudent( Student student){
        return  studentRepository.addStudent(student) ;
    }
    public Student getStudent(int id){
        return studentRepository.getStudent(id) ;
    }
    public String updateStudent( int id , int age){
        return  studentRepository.updateStudent(id , age) ;
    }
    public String deleteStudent(int id){
        return  studentRepository.deleteStudent(id);
    }
}
