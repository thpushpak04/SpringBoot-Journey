package in.pushpak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("in.pushpak")
public class AppConfig {

    @Bean
    public Student student(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name & age");
        String name = sc.nextLine();
        int age = sc.nextInt();
        return new Student(name,age); // most imp line - u have to return the object of that class and
                                    // method name will be same as the given class name
    }
}
