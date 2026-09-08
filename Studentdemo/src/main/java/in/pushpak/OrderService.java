package in.pushpak;

public class OrderService {

    //NotificationService notificationService = new EmailService(); // implemented Interface
    //SmsService smsService = new SmsService();
    NotificationService notificationService;

    /**OrderService(NotificationService notificationService){
        this.notificationService = notificationService;
    }**/

    public void setNotificationService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void makeOrder(){
        System.out.println("order created by using setter method");
        notificationService.sendMessage();
    }
}
