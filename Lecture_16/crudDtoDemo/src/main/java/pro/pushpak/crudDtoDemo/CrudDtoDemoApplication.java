package pro.pushpak.crudDtoDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class CrudDtoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDtoDemoApplication.class, args);
		System.out.println("hello");
	}

}
