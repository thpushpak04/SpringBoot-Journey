package in.pushpak.SpringBootRevision;

import org.jspecify.annotations.NonNull;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements ApplicationRunner {
    //implement DI

    private PaymentGateway paymentGateway;

    DemoRunner(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void run(@NonNull ApplicationArguments args) throws Exception {
        paymentGateway.print();
    }
}
