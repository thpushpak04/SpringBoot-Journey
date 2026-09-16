package in.pushpak;

import in.pushpak.Payment.AccountService;
import in.pushpak.Payment.CardService;
import in.pushpak.Payment.UpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AdmissionService {

    AccountService accountService;
    Student student;

    @Autowired
    AdmissionService(@Qualifier("cs") AccountService accountService,Student student){
        this.accountService = accountService;
        this.student = student;
    }

    public void takeAdmission(){
        accountService.pay();
        System.out.println("Admission Successful");
        System.out.println(student.name+" is our student now");
    }
}
