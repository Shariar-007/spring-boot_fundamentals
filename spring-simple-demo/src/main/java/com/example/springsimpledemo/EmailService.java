package com.example.springsimpledemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    static List<Email> emails = new ArrayList<>();

    static {
        emails.add(new Email("One", "First Mail"));
        emails.add(new Email("Two", "Second Mail"));
        emails.add(new Email("Third", "Third Mail"));
    }

    public Email getEmailByTitle(String title) {
        for (Email email : emails) {
            if (email.getTitle().equals(title)) {
                return email;
            }
        }
        return null;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void save(Email email) {
        emails.add(email);
    }
}
