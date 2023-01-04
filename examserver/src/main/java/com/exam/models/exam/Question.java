package com.exam.models.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;

    @Column(length = 5000)
    private String content;

    private String image;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

//    @JsonIgnore()
//    @JsonProperty(value = "answer", access = JsonProperty.Access.WRITE_ONLY)
    private String answer;

    @Transient
    private String givenAnswer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;
}
