package in.pushpak.crudSpringBootDemo.service;

import in.pushpak.crudSpringBootDemo.dto.CreateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.CreateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto){
        // business logic
        Student student = mapToEntity(createStudentRequestDto);

        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);

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
    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        //taking input from request to update the details
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);

        return mapToUpdateDto(savedStudent);

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

    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto){
        Student student = new Student();

        student.setName(createStudentRequestDto.getName());
        student.setAge(createStudentRequestDto.getAge());
        student.setEmail(createStudentRequestDto.getEmail());
        student.setRollNo(createStudentRequestDto.getRollNo());
        student.setSubject(createStudentRequestDto.getSubject());

        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now()); // setting current time
        student.setUpdatedAt(LocalDateTime.now());

        return student;
        //builder design pattern, we will use in future
    }

    private CreateStudentResponseDto mapToDto(Student student){
        CreateStudentResponseDto createStudentResponseDto = new CreateStudentResponseDto();

        createStudentResponseDto.setId(student.getId());
        createStudentResponseDto.setName(student.getName());
        createStudentResponseDto.setAge(student.getAge());
        createStudentResponseDto.setEmail(student.getEmail());
        createStudentResponseDto.setRollNo(student.getRollNo());
        createStudentResponseDto.setSubject(student.getSubject());

        createStudentResponseDto.setMessage("Student saved successfully");

        return createStudentResponseDto;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student savedStudent){
        UpdateStudentResponseDto updateStudentResponseDto =
                new UpdateStudentResponseDto();

        updateStudentResponseDto.setAge(savedStudent.getAge());
        updateStudentResponseDto.setEmail(savedStudent.getEmail());
        //updateStudentResponseDto.setCreatedAt(savedStudent.getCreatedAt());
        updateStudentResponseDto.setId(savedStudent.getId());
        updateStudentResponseDto.setName(savedStudent.getName());
        updateStudentResponseDto.setRollNo(savedStudent.getRollNo());
        updateStudentResponseDto.setSubject(savedStudent.getSubject());
        updateStudentResponseDto.setUpdatedAt(savedStudent.getUpdatedAt());
        updateStudentResponseDto.setDeleted(false);
        updateStudentResponseDto.setMessage("Student Updated successfully");

        return updateStudentResponseDto;
    }




    /**
     * 1. End Point Listen (/app/students POST)
     * 2. Business Logic
     * 3. Interact with DB to store
     * 4. Response back to client(postman)
     *
     */

}
