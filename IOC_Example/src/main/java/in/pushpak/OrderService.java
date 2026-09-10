package in.pushpak;

import in.pushpak.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {

    //@Autowired // Dependency Injection - Field (TYPE 3 of DI)
    private PaymentService paymentService;

    /**@Autowired  // Dependency Injection - Setter (Type 2 of DI)
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }*/

    @Autowired // Dependency Injection - Constructor (Type 1 of DI)
    public OrderService(@Qualifier("cp") PaymentService paymentService){ // card payment & upi payment both are types of Payment service
        this.paymentService = paymentService;
    }



    public void placeOrder(){

        paymentService.pay();

        System.out.println("order placed");
    }
}

/** why dependency Injection is recommended instead of Setter Injection & field Injection
 *
 * 1) dependency get wired at the time of object creation itself
 * 2) final can be used( meaning just one time object/ value intialization using constructor
 * 3) unit testing is easy to perform.
 *
 * ****** INTERNALS OF SPRING MANAGING BEANS - ApplicationContext & AnnotationConfigApplicationContext(AppConfig.class)******
 *
 */



