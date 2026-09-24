package in.pushpak;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") // one single same object for all - initialize as fast when IOC container gets create.
@Scope("prototype") // lazy initialization - when there is a need then only creation will be there
public class OrderService {

    public OrderService(){
        System.out.println("ORDERSERVICE CREATED");
    }

    public void placeOrder(){
        System.out.println("Order Placed");
    }
}
