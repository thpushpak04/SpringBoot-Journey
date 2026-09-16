package in.pushpak;

import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;

public class Student {

    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    // example to use @Bean Configuration
}
