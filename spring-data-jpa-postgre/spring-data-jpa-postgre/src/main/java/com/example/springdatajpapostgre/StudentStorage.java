package com.example.springdatajpapostgre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStorage extends JpaRepository<Student, Long> {
}
