package com.example.springdatajpapostgre;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Student")
@Table(name="Student",
        uniqueConstraints = {
         @UniqueConstraint(
                 name = "student_email_unique",
                 columnNames = "email"
         )
        }
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String email;

    @Column(name = "age",updatable = false)
    private Integer age;

    public Student() {
    }
    public Student(String firstName,
                   String lastName,
                   String email,
                   Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String Student (){
        return "Student{" + "id=" + id +
                ",firstName:'" + firstName + '\'' +
                ",lastName=+" + lastName + '\'' +
                ",email=" + email + '\'' +
                ",age="+ age + '\'' +
                "}";

    }
}
