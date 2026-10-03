package in.pushpak.SpringBootPart_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    /**private String type;
    private int retryCount;*/

    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties){
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCount(){
        return paymentProperties.getRetrycount();
    }

    public boolean isEnabled(){
        return paymentProperties.isEnabled();
    }

    public void print(){
        System.out.println(getRetryCount());
        System.out.println(getType());
        System.out.println(isEnabled());
    }


    /**   public PaymentGateway(@Value("${paymentGateway.type:Razorpay}") String type, // added a default value Razorpay too.
                          @Value("${paymentGateway.retryCount:1}") int retryCount) {
        this.type = type;
        this.retryCount = retryCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }*/
}
