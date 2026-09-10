package in.pushpak;

import in.pushpak.payment.CardPayment;
import in.pushpak.payment.PaymentService;
import in.pushpak.payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("in.pushpak")
public class AppConfig {
    //empty

    @Bean
    public User createUser(){
        return new User("Alex",26);
    }

    @Bean // khud se object bnaao bas handle Spring krega
    @Qualifier("cp")
    public PaymentService createCardPayment(){
        return new CardPayment();
    }

    @Bean
    //@Primary
    @Qualifier("up")
    public PaymentService createUpiPayment(){
        return new UpiPayment();
    }

    @Bean
    public OrderService createorderService(@Qualifier("up")PaymentService paymentService){
        return new OrderService(paymentService);
    }
}
