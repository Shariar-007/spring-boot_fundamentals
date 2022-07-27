package com.example.springsimpledemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Integer> {

    @Query(value = "SELECT email FROM Email email WHERE email.title = ?1")
    public Email getEmailByTitle(String title);
}
