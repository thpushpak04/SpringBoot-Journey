package in.pushpak.crudSpringBootDemo.service;

import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    // Create - method
    public Student createStudent(Student studentReq){
        // business logic
        // store to db

        System.out.println("Inside student service");
        Student studentResp = studentRepository.save(studentReq);
        System.out.println("Exiting student service");
        return studentResp;
    }


    // read - method(by id)
    public Student getStudent(Long id){
        Optional<Student> StudentResp = studentRepository.findById(id);

        if(StudentResp.isPresent()){
            return StudentResp.get();
        }

        return null;
    }


    // readAll - method
    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        return studentList;

    }

    //update query
    public Student updateStudent(Long id, Student studentReq){
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        //taking input from request to update the details
        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());

        return studentRepository.save(studentToSave);

    }

    // delete - method(by id)
    public Student deleteStudent(Long id){

        Optional<Student> StudentResp = studentRepository.findById(id); //stores the value we r deleting
        studentRepository.deleteById(id); // deleted it

        if(StudentResp.isPresent()){ // checked the store data is present, if yes then return that to controller to client
            return StudentResp.get();
        }

        return null;  // unless return null

    }






    /**
     * 1. End Point Listen (/app/students POST)
     * 2. Business Logic
     * 3. Interact with DB to store
     * 4. Response back to client(postman)
     *
     */

}
