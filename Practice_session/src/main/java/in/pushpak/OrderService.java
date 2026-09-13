package in.pushpak;

import in.pushpak.payment_options.CardPayment;
import in.pushpak.payment_options.PaymentService;
import in.pushpak.payment_options.UpiPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    //PaymentService paymentService = new CardPayment();
    //PaymentService paymentService = new UpiPayment();

    PaymentService paymentservice;

    @Autowired
    OrderService(PaymentService paymentservice){
        this.paymentservice = paymentservice;
    }

    public void placeOrder(){
        System.out.println("order created");
        paymentservice.pay();
    }
}
