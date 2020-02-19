package com.spring.project1.project1.repository;

import com.spring.project1.project1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// jpaRepository를 상속받은 interface를 만들면 crud메소드를 가집
public interface PersonRepository extends JpaRepository<Person, Long> { // Long은 Id타입임

}
