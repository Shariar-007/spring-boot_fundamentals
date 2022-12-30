package com.exam.helper;


public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super(String.format("User Not Found"));
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
