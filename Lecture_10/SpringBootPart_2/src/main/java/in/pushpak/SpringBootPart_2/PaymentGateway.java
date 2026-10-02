package in.pushpak.SpringBootPart_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private String type;
    private int retryCount;

    public PaymentGateway(@Value("${paymentGateway.type}") String type,
                          @Value("${paymentGateway.retryCount}") int retryCount) {
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
    }
}
