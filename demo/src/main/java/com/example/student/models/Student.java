package com.example.student.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {

    public final UUID id;
    public final String name;
    public final String universityName;
    public final int semester;
    public final float cgpa;


    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name,
                   @JsonProperty("universityName") String universityName,
                   @JsonProperty("semester") int semester,
                   @JsonProperty("cgpa") float cgpa) {
        this.id = id;
        this.name = name;
        this.universityName = universityName;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public String getUniversityName() {
        return universityName;
    }

    public int getSemester() {
        return semester;
    }

    public float getCgpa() {
        return cgpa;
    }
}
