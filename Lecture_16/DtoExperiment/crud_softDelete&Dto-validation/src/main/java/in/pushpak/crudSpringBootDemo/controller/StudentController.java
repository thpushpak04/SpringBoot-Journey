package in.pushpak.crudSpringBootDemo.controller;

import in.pushpak.crudSpringBootDemo.dto.CreateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.CreateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @RequestBody CreateStudentRequestDto createStudentRequestDto){ // @    RequestBody annotation makes the json to the class/object data
        //System.out.println("Inside Student Controller");
        CreateStudentResponseDto createdStudent = studentService.createStudent(createStudentRequestDto); // calling a method from studentservice
        //System.out.println("Exiting student Controller");
        return ResponseEntity.status(201).body(createdStudent); // response entity is used for status code mainly here
    }

    // read one student
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
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
    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> putStudent(@RequestParam Long id,
                                                               @RequestBody UpdateStudentRequestDto studentReq){

        //USE requestparam when there is more than one variable like id and name
        UpdateStudentResponseDto studentResp = studentService.updateStudent(id, studentReq);

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

    //delete - softly
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if (!isDeleted){
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .ok("Record deleted");
    }


}
