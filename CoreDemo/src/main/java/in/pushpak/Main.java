package in.pushpak;

import in.pushpak.notification.EmailService;
import in.pushpak.notification.FakeEmailService;
import in.pushpak.notification.NotificationService;
import in.pushpak.notification.PopUpNotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationService notification = new PopUpNotificationService(); // making object of different services here like sms & email service
        //OrderService order = new OrderService(notification); // sharing that object to the constructor
        OrderService order = new OrderService();
        order.setNotification(notification); // Dependency injection using getter and setter
        order.placeOrder();
    }
}
// dependency ab bhaar se mil rhi hai ... main class se...this is called dependency injection. this should not create his own dependency ...so main class is creating that dependency an sending over constructor
//