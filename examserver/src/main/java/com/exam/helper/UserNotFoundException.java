package com.exam.helper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super(String.format("User Not Found"));
    }
}
