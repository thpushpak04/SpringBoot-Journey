package pro.pushpak.profileDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class ProfileDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileDemoApplication.class, args);
		System.out.println("hello");
	}
}
