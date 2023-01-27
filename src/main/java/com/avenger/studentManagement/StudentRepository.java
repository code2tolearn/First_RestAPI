package com.avenger.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Repository
public class StudentRepository {

    HashMap<Integer, Student> db = new HashMap<>();
 // get
    public Student getStudent(int admnNo) {
        return db.get(admnNo);
    }
 // add
    public String addStudent(Student student) {
        db.put(student.getAdmnNo(), student);
        return "Student added successfully ";
    }
 // update
    public String updateStudent(int id, int age) {
        if (!db.containsKey(id)) {
            return null ;
        }
        db.get(id).setAge(age);
        return "Student updated successfully";
    }
// delete
    public String deleteStudent(int id) {
        if (!db.containsKey(id)) {
            return "Invalid Id";
        }
        db.remove(id);
        return "Deleted Successfully ";
    }
}
