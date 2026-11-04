package in.pushpak.crudSpringBootDemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message = "name can't be null/empty or blank")
    @Size(min = 2, max = 50, message = "Student name must be in range")
    private String name;

    @Min(value = 18)
    @NotNull(message = "Age is required")
    private Integer age;

    @Email(message = "student email must be valid")
    private String email;

    @NotNull(message = "roll no. is compulsory")
    private Integer rollNo;

    @NotBlank(message = "Subject is compulsory")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
