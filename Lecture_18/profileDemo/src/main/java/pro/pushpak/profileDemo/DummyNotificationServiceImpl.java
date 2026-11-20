package pro.pushpak.profileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyNotificationServiceImpl implements NotificationService{
    @Override
    public String message() {
        return "Dummy Notification";
    }
}
