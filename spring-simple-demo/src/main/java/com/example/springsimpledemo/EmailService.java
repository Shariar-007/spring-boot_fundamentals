package com.example.springsimpledemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

//    static List<Email> emails = new ArrayList<>();
//
//    static {
//        emails.add(new Email("One", "First Mail"));
//        emails.add(new Email("Two", "Second Mail"));
//        emails.add(new Email("Third", "Third Mail"));
//    }

    public Email getEmailByTitle(String title) {
        return this.emailRepository.getEmailByTitle(title);
    }

    public List<Email> getEmails() {
        return this.emailRepository.findAll();
    }

    public void save(Email email) {
        this.emailRepository.save(email);
    }

    public void delete(Integer emailId){
        this.emailRepository.deleteById(emailId);
    }

//    public
}
