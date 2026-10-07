package in.pushpak.SpringBootRevision.Service;

import in.pushpak.SpringBootRevision.Repository.StudentRepository;
import in.pushpak.SpringBootRevision.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // here business logic

    // execute the DI
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student makeStudent(){
        System.out.println("Inside Service");
        Student StudentResp = studentRepository.sendData();
        System.out.println("Exiting service");
        return StudentResp;
    }
}
