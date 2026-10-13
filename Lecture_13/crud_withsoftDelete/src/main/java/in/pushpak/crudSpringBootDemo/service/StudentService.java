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

    //dependency injection
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    // Create - method
    public Student createStudent(Student studentReq){
        // business logic
        //System.out.println("Inside student service");

        //setting the setdeletdFalse

        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        //System.out.println("Exiting student service");
        return studentResp;
    }


    // read - method(by id)
    public Student getStudent(Long id){
        Optional<Student> StudentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        if(StudentResp.isPresent()){
            return StudentResp.get();
        }

        return null;
    } //  select * from student where id = 1 and deleted = false
    //findByIdAndDeletedFalse


    // readAll - method
    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        return studentList;

    } // select * from employee where deleted = false.


    //update query
    public Student updateStudent(Long id, Student studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

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
        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);

    } // update student

    // delete - method(by id)
    public Student deleteStudent(Long id){

        Optional<Student> StudentResp = studentRepository.findById(id); //stores the value we r deleting
        studentRepository.deleteById(id); // deleted it

        if(StudentResp.isPresent()){ // checked the store data is present, if yes then return that to controller to client
            return StudentResp.get();
        }

        return null;  // unless return null

    }


    //delete-- and softly
    public Boolean deleteStudentSoftly(Long id){
        //get
        // deleted = 1
        //save

        // step 1:- getting the data of a student with id
       Optional<Student> existingStudent =
               studentRepository.findByIdAndDeletedIsFalse(id);

       if(existingStudent.isEmpty()){
           return false; // checking whether it is empty or full
       }

       Student studentToSave = existingStudent.get();
       //storing the data existingstudent(means data with id) into a StudentTosave variable

       studentToSave.setDeleted(true);
       // now we toggle on the setDeleted to true. by which it says this data is soft deleted.

       studentRepository.save(studentToSave);
       //then at the end, once again saved this data.

       return true; // returned true that work is done.

    }






    /**
     * 1. End Point Listen (/app/students POST)
     * 2. Business Logic
     * 3. Interact with DB to store
     * 4. Response back to client(postman)
     *
     */

}
