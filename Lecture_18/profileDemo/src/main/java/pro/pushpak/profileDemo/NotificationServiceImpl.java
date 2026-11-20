package pro.pushpak.profileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificationServiceImpl implements NotificationService{
    @Override
    public String message() {
        return "Hello Notification";
    }
}
