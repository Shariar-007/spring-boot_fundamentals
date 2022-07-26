package com.example.springsimpledemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @GetMapping
    public List<Email> getEmail(@RequestParam(required = false) String title) {

        if (title == null) {
            return emailService.getEmails();
        }

        List<Email> foundedMail = new ArrayList<>();
        Email email = this.emailService.getEmailByTitle(title);

        if (email != null) {
            foundedMail.add(email);
        }

        if (foundedMail.isEmpty()) {
            throw new EmailErrorHandle();
        }

        return foundedMail;
    }

    @PostMapping
    public void addEmail(@RequestBody Email email){
        emailService.save(email);
    }

}
