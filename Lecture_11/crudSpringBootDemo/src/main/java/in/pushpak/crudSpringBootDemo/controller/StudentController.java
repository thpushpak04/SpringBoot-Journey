package in.pushpak.crudSpringBootDemo.controller;

import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// not @component
@RestController
@RequestMapping("/api/students")
public class StudentController {

    // dependency injection
    private StudentService studentService;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){ // @    RequestBody annotation makes the json to the class/object data
        //System.out.println("Inside Student Controller");
        Student createdStudent = studentService.createStudent(student); // calling a method from studentservice
        //System.out.println("Exiting student Controller");
        return ResponseEntity.status(201).body(createdStudent); // response entity is used for status code mainly here
    }

    // read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);

    }

    // read all student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);


    }


    // update student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable Long id,
                                              @RequestBody Student studentReq){

        Student studentResp = studentService.updateStudent(id, studentReq);

        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);

    }

    // delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){

        Student studentResp = studentService.deleteStudent(id);

        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);

    }

}
