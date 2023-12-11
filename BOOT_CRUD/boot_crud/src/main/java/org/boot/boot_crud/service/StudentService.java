package org.boot.boot_crud.service;

import org.boot.boot_crud.dao.StudentDao;
import org.boot.boot_crud.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentDao dao;
    public Student save(Student  student){
        int total=
       
        
        dao.save(student);
    }
    
}
