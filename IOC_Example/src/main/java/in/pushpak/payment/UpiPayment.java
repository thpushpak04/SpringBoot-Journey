package in.pushpak.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary - make it primary and favoured one
//@Qualifier("up")
public class UpiPayment implements PaymentService{

    @Override
    public void pay(){
        System.out.println("UPI payment successful");
    }
}
