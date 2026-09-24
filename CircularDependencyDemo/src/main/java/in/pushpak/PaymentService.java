package in.pushpak;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    OrderService orderService;

    PaymentService(OrderService orderService){
        this.orderService = orderService;
    }

    public void pay(){
        System.out.println("Payment Done");
        orderService.getOrderDetails();
    }
}
