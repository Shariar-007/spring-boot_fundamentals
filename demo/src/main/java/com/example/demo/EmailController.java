package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class EmailController {
//    static List<Email> emails = new ArrayList<>();

    @Autowired
    EmailService emailService;


    @GetMapping("email")
    public List<Email> getEmailByTitle(@RequestParam String title) throws EmailNotFoundException {
        List<Email> emails = new ArrayList<>();
        Email email = emailService.getEmailByTitle(title);

        if(email != null){
            emails.add(email);
        }

        if(emails.isEmpty()){
            throw new EmailNotFoundException();
        }

        return emails;
    }


    public List<Email> getAllMails(){
        return this.emailService.getEmails();
    }

//    @PostMapping("/email")
//    public List<Email> setEmail(@RequestBody Email email){
//        List emails = emailService.setEmails(email);
//        return emails;
//    }


}
