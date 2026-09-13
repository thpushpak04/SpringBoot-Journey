package in.pushpak.payment_options;

import org.springframework.stereotype.Component;

@Component

public class CardPayment implements PaymentService{

    @Override
    public void pay() {
        System.out.println("paid using the Card");
    }
}
