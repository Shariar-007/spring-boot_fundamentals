package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmailService {
    static List<Email> emails = new ArrayList<>();

    static {
        emails.add(new Email("One","First Mall"));
        emails.add(new Email("Second","Second Mall"));
    }

    @GetMapping("emails")
    public List<Email> getEmails(){
        return emails;
    }

    public Email getEmailByTitle(String title){
        for(Email email:emails){
            if(email.getTitle().equalsIgnoreCase(title)){
                return email;
            }
        }
        return null;
    }

    @PostMapping("email")
    public List<Email> setEmails(@RequestBody Email email){
        emails.add(email);
        return emails;
    }


}
