package in.pushpak.SpringBootRevision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootRevisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRevisionApplication.class, args);

		System.out.println("Hello");
	}

}

// now 4 structure
