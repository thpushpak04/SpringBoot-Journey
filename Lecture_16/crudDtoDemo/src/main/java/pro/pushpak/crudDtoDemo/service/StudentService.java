package pro.pushpak.crudDtoDemo.service;

import org.springframework.stereotype.Service;
import pro.pushpak.crudDtoDemo.entity.Student;
import pro.pushpak.crudDtoDemo.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //create
    public Student createStudent(Student studentReq){
        return studentRepository.save(studentReq);
    }
}
