package com.example.springsimpledemo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "Email")
public class Email {
    @Column
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @NotBlank
    private String title;

    @Column
    private String description;

    public Email(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Email() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
