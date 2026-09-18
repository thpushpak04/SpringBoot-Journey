package in.pushpak;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    PaymentService paymentService;

    OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order placed");
    }

    public void getOrderDetails(){
        System.out.println("Order Details");
    }

}
