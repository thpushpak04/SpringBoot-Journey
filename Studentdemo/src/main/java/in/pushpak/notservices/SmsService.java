package in.pushpak.notservices;

import in.pushpak.NotificationService;

public class SmsService implements NotificationService {

    @Override
    public void sendMessage(){
        System.out.println("Sms service");
    }
}
