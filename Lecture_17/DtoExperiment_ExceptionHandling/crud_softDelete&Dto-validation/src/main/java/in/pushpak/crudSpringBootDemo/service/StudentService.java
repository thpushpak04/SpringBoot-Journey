package in.pushpak.crudSpringBootDemo.service;

import in.pushpak.crudSpringBootDemo.dto.CreateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.CreateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.pushpak.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.pushpak.crudSpringBootDemo.entity.Student;
import in.pushpak.crudSpringBootDemo.exception.DuplicateResourceException;
import in.pushpak.crudSpringBootDemo.exception.ResourceNotFoundException;
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

        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email" + student.getEmail() + "is already exists");
        }

        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);

    }


    // read - method(by id)
    public CreateStudentResponseDto getStudent(Long id){
        Student StudentResp = studentRepository
                .findById(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("Student with id" + id +"not found"));

        return mapToDto(StudentResp);
    }


    // readAll - method
    public List<CreateStudentResponseDto> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        //java stream syntax - can use for loop too
        return studentList.stream()
                .map(this::mapToDto)
                .toList();

    } // select * from employee where deleted = false.


    //update query
    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id" + id +"not found"));

        existingStudent.setName(studentReq.getName());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);

        return mapToUpdateDto(savedStudent);

    } // update student

    // delete - method(by id)
    public void deleteStudent(Long id){

        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id" + id +"not found"));

        //stores the value we r deleting
        studentRepository.delete(studentToBeDeleted); // deleted it

    }


    //delete-- and softly
    public void deleteStudentSoftly(Long id){
        //get
        // deleted = 1
        //save

        // step 1:- getting the data of a student with id
       Student existingStudent =
               studentRepository
                       .findByIdAndDeletedIsFalse(id)
                       .orElseThrow(()-> 
                               new ResourceNotFoundException("Student with id" + id +"not found"));
       

       existingStudent.setDeleted(true);
       // now we toggle on the setDeleted to true. by which it says this data is soft deleted.

       studentRepository.save(existingStudent);
       //then at the end, once again saved this data.


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

    private boolean emailExists(Student student){
        // method to check whether user with same email exists or not
        return studentRepository.existsByEmail(student.getEmail());
    }




    /**
     * 1. End Point Listen (/app/students POST)
     * 2. Business Logic
     * 3. Interact with DB to store
     * 4. Response back to client(postman)
     *
     */

}
