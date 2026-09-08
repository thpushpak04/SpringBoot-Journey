package in.pushpak;

import in.pushpak.notification.EmailService;
import in.pushpak.notification.NotificationService;
import in.pushpak.notification.SmsService;

public class OrderService {

    //NotificationService notification = new SmsService(); // dependent to the email service
    //tightly coupled
    // used the interface here

    NotificationService notification;// instance variable- not creating notification object, following solid principle

    public OrderService(NotificationService notification){
        this.notification = notification;
    }

    public OrderService(){

    }

    public void placeOrder(){
        System.out.println("Order Placed");
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
} // dependency ab bhaar se mil rhi hai ... main class se...this is called dependency injection. this should not create his own dependency ...so main class is creating that dependency an sending over constructor
