package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

//@Configuration
public class StudentConfig {
    @Bean

    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
//            Student madalin = new Student(
//                    "madalin",
//                    LocalDate.of(2000, JANUARY,5),
//                    "madalin@gmail.com"
//            );
//            Student alex = new Student(
//                    "alex",
//                    LocalDate.of(2005, FEBRUARY,16),
//                    "alex@gmail.com"
//            );
//            repository.saveAll(
//                    List.of(madalin, alex));
        };
    }
}
