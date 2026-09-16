package in.pushpak.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("cs")
public class CardService implements AccountService {

    public void pay(){
        System.out.println("Paid using the Card");
    }
}
