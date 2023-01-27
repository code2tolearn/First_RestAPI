package com.avenger.studentManagement;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// which type of API we made rest API so
 @RestController
public class StudentController {
// DB is used for permanent store
 Map<Integer , Student> db = new HashMap<>() ;
 // get read operation
  @GetMapping("/get_student")
 public ResponseEntity getStudent(@RequestParam("admnNo")  int admnNo){

    return new ResponseEntity<>(studentService.getStudent(admnNo), HttpStatus.FOUND) ;
 }
 // adding the information
 @Autowired
 StudentService studentService ;

 @PostMapping("/add_student")
 public ResponseEntity addStudent(@RequestBody Student student){
   String responce = studentService.addStudent(student) ;
  return new ResponseEntity<>(responce , HttpStatus.CREATED) ;
 }
 // so url localhost:8080/add_student
 // Adding using path variable
// @GetMapping("/get_student/{admnNo}")
// public Student getStudent(@PathVariable("admnNo") int admnNo){
//     return studentService.getStudent(admnNo) ;
// }



 // put mapping update
 @PutMapping("/update_student")
 public ResponseEntity updateStudent(@RequestParam("id") int id ,@RequestParam("age") int age)
 {
       String responce = studentService.updateStudent(id , age) ;
       if(responce == null ) return new ResponseEntity<>("Invalid Request" , HttpStatus.NOT_ACCEPTABLE) ;
      return new ResponseEntity<>(responce,HttpStatus.ACCEPTED) ;
 }
 @DeleteMapping("/delete_student")
 public ResponseEntity deleteStudent(@RequestParam("id") int id){
     String response = studentService.deleteStudent(id) ;
     if(response.equals("Invalid Id"))  return new ResponseEntity<>("Invalid Id",HttpStatus.BAD_REQUEST) ;
    return new ResponseEntity<>(response ,HttpStatus.ACCEPTED);
 }
}
