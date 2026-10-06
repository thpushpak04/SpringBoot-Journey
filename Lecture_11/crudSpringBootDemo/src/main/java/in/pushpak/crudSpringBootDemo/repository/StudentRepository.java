package in.pushpak.crudSpringBootDemo.repository;

import in.pushpak.crudSpringBootDemo.entity.Student;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq){

        //save to db.
        System.out.println("inside student repository");
        System.out.println("Exiting student Repository");

        Student s1 = new Student(); // NO @component so not handling by spring
        s1.setName("Rishabh");
        s1.setAge(21);
        s1.setEmail("thrishabh11@gmail.com");
        s1.setRollNo(101);
        s1.setSubject("Spring framework");

        return s1;
    }
}
