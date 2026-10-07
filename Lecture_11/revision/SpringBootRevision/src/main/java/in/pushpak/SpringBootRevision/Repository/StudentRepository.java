package in.pushpak.SpringBootRevision.Repository;

import in.pushpak.SpringBootRevision.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    //use to send the data

    /**use the DI for entity
    private Student student;
    private String result

    public StudentRepository(Student student){
        this.student = student;
    }

    public String sendData{
        result = "data saved successfully";
    }
    return result;*/

    Student s1 = new Student();

    public Student sendData(){
        System.out.println("Inside Repository");
        System.out.println("exiting repository");

        s1.setName("Pushpak");
        s1.setAge(21);
        s1.setId(2);
        s1.setSubject("Spring");
        return s1;
    }
}
