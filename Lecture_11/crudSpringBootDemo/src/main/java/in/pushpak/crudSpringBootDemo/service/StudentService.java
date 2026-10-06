package in.pushpak.crudSpringBootDemo.service;

import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        // business logic
        // store to db

        System.out.println("Inside student service");
        Student studentResp = studentRepository.saveStudent(studentReq);
        System.out.println("Exiting student service");
        return studentResp;
    }






    /**
     * 1. End Point Listen (/app/students POST)
     * 2. Business Logic
     * 3. Interact with DB to store
     * 4. Response back to client(postman)
     *
     */

}
