package in.pushpak.EmployeeCrudSd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class EmployeeCrudSdApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudSdApplication.class, args);
		System.out.println("hello");
	}

}
