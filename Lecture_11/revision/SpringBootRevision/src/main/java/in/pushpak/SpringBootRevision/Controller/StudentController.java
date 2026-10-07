package in.pushpak.SpringBootRevision.Controller;

import in.pushpak.SpringBootRevision.Service.StudentService;
import in.pushpak.SpringBootRevision.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    //execute DI
    private StudentService studentService;


    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    //Create
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){ // requestBODY annotation ofc will come up at
                                                                // post method or where we r receiving the request
        System.out.println("Inside Controller");
        Student createdStudent = studentService.makeStudent();
        System.out.println("Exiting Controller");
        System.out.println(student.getName());

        return createdStudent;
    }
}
