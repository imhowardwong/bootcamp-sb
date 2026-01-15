package com.bootcamp.demo_basic_api.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo_basic_api.model.Database;
import com.bootcamp.demo_basic_api.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@ResponseBody
@Controller
@RequestMapping (value = "/student")
public class StudentController {
  //PostMapping
  @PostMapping(value = "/")
  public Student create(@RequestBody Student student) {
      return Database.students.add(student) ? student : null;
  }
  
  // @GetMapping(value = "/all")
  // public List<Student> getAllStudents {
  //     return Database.student;
  // }
  @GetMapping(value = "/all")
  public List<Student> getAllStudents(){
      return Database.students;
  }
  
  
}
