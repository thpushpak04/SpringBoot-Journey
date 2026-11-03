package pro.pushpak.crudDtoDemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.pushpak.crudDtoDemo.entity.Student;
import pro.pushpak.crudDtoDemo.repository.StudentRepository;
import pro.pushpak.crudDtoDemo.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;

    //autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //create
    @PostMapping()
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student studentRes = studentService.createStudent(Student student);

        if(studentRes == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentRes);
    }
}
