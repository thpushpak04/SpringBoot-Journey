package in.pushpak.EmployeeDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class EmployeeDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeDemoApplication.class, args);
		System.out.println("hello");
	}

}
