package in.pushpak.SpringBootRevision;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private String type;
    private int retryCount;

    PaymentGateway(@Value("${PaymentGateway.type:Upi}") String type,
                   @Value("${PaymentGateway.retryCount}") int retryCount ){
        this.type = type;
        this.retryCount = retryCount;
    }

    public String result(){
        return type;
    }

    public int getRetryCount(){
        return retryCount;
    }

    public void print(){
        System.out.println(result());
        System.out.println(getRetryCount());
    }
}
