package com.example.springsimpledemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;


//    @GetMapping
//    public List<Email> getEmails() {
//        return this.emailService.getEmails();
//    }

    @GetMapping
    public ResponseEntity<List<Email>> getEmailByTitle(@RequestParam(required = false) String title) {
        if (title == null) {
            return ResponseEntity.ok(emailService.getEmails());
        }
        List<Email> foundedMail = new ArrayList<>();
        Email email = emailService.getEmailByTitle(title);
        if (email != null) {
            foundedMail.add(email);
        }
        if (foundedMail.isEmpty()) {
            throw new EmailErrorHandle();
        }
        return ResponseEntity.ok(foundedMail);
    }

    @PostMapping
    public void addEmail(@Valid @RequestBody Email email) {
        emailService.save(email);
    }


    @DeleteMapping(path = "{emailId}")
    public void removeEmail(@PathVariable("emailId") Integer emailId) {
        emailService.delete(emailId);
    }

}
