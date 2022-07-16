package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeetingController {

    @GetMapping("/email")
    public Email getEmail(){
        Email email = new Email();
        email.setTitle("Shariar");
        email.setDescription("Goole Mail");
        return email;
    }

//    @RequestMapping(value = "/newMessage", method = RequestMethod.GET)
//    public String getMessages(){
//        return "New Hello World";
//    }

}
