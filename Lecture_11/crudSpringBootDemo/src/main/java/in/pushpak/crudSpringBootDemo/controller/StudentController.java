package in.pushpak.crudSpringBootDemo.controller;

import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// not @component
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){ // @    RequestBody annotation makes the json to the class/object data
        System.out.println("Inside Student Controller");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("Exiting student Controller");
        return ResponseEntity.status(201).body(createdStudent); // response entity is used for status code mainly here
    }

    // read student

    // update student

    // delete student
}
