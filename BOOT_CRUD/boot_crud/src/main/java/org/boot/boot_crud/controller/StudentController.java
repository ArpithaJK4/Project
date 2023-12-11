package org.boot.boot_crud.controller;

import org.boot.boot_crud.dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

//     @RequestMapping("/abc")
//     @ResponseBody
//  public String hello(){
//     return "Hello";
// }
    @PostMapping("/students")
    // public String save(){

    // return "in Save";
     public Student save(@RequestBody Student student){
        return  student;
    }
    }

