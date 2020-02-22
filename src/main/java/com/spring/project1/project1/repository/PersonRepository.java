package com.spring.project1.project1.repository;

import com.spring.project1.project1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

// jpaRepository를 상속받은 interface를 만들면 crud메소드를 가집
public interface PersonRepository extends JpaRepository<Person, Long> { // Long은 Id타입임
    List<Person> findByName (String name);
    List<Person> findByBlockIsNull();
    List<Person> findByBloodType(String booldType);
    List<Person> findByBirthdayBetween (LocalDate startDate, LocalDate endDate);
}
