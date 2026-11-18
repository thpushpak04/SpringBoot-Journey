package in.pushpak.crudSpringBootDemo.controller;

import in.pushpak.crudSpringBootDemo.dto.CreateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.CreateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
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
    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto createStudentRequestDto){ // @    RequestBody annotation makes the json to the class/object data

        //@valid usage for validation
        CreateStudentResponseDto createdStudent =
                studentService.createStudent(createStudentRequestDto); // calling a method from studentservice

        return ResponseEntity
                .status(201)
                .body(createdStudent); // response entity is used for status code mainly here
    }

    // read one student
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id){
        CreateStudentResponseDto studentResp = studentService.getStudent(id);

        return ResponseEntity.ok(studentResp);

    }

    // read all student
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent(){
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();

        return ResponseEntity.ok(studentList);


    }


    // update student
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> putStudent(@RequestParam Long id,
                                                               @RequestBody UpdateStudentRequestDto studentReq){

        //USE requestparam when there is more than one variable like id and name
        UpdateStudentResponseDto studentResp = studentService.updateStudent(id, studentReq);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);

    }

    // delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){

        studentService.deleteStudent(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();

    }

    //delete - softly
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
        studentService.deleteStudentSoftly(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }


}

/**
 * For validations --> spring-boot-starter-validation
 *
 * plot twist as there will be as an output there will be 404 bad request
 * the response will be created by spring boot by itself...
 *
 * so for our desired output to show user that we require this and that
 * we have to override it... and for that we need exception handling...
 *
 * guess what it's our next lecture... bhot mazaa aaya
 */
