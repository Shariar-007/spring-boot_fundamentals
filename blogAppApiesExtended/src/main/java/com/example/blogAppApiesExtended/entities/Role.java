package com.example.blogAppApiesExtended.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Role {

    @Id
    private int id;

    private String name;

    private String code;
}
