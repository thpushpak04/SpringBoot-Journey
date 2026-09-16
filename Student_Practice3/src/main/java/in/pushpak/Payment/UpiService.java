package in.pushpak.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("up")
public class UpiService implements AccountService {

    public void pay(){
        System.out.println("Paid using UPI");
    }
}
