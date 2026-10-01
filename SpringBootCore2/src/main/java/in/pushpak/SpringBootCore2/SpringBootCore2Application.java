package in.pushpak.SpringBootCore2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "in.pushpak")
public class SpringBootCore2Application {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(SpringBootCore2Application.class, args);

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}

}

/**
 * @SpringBootConfiguration = @Configuration is almost the same, in that there will be similiar configuration file like things...
 * where a client will specify the meta data and data required to start the application...
 * also a client will create the @bean at the SpringBootCoreApplication class.
 *
 * @ComponentScan is similiar to spring core ...which is use to search the beans(component) in a same package.
 *
 * A client can specify which package to search in similar manner like ...
 * @SpringBootApplication(scanBasePackages = "in.pushpak")
 *
 * @EnableAutoConfiguration = look at my project and create any beans seem important to you.
 *
 * *** There are two ways to make beans
 * ---> @Component , @Bean
 *
 * But Spring Boot uses @AutoConfiguration to make Beans
 */
