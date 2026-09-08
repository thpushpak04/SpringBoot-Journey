package in.pushpak.notservices;

import in.pushpak.NotificationService;

public class EmailService implements NotificationService {

    @Override
    public void sendMessage(){
        System.out.println("email sent using setter method");
    }
}
