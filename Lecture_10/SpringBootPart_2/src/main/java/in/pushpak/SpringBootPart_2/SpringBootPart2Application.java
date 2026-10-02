package in.pushpak.SpringBootPart_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootPart2Application {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(SpringBootPart2Application.class, args);

		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
		//paymentGateway.setType("Paytm");
		//paymentGateway.setRetryCount(5);

		System.out.println(paymentGateway.getRetryCount()+" "+paymentGateway.getType());
	}

}
