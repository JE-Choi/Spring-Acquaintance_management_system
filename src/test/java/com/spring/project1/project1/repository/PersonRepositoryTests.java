package com.spring.project1.project1.repository;

import com.spring.project1.project1.domain.Person;
import com.spring.project1.project1.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Transactional // 트랜잭션이 rollback되도록
@SpringBootTest
class PersonRepositoryTests {
    @Autowired
    private PersonRepository personRepository;
    @Test
    void crud(){
        Person person = new Person();
        person.setName("Dave");
        person.setAge(23);
        person.setBloodType("A");
        personRepository.save(person);

        List<Person> result = personRepository.findByName("Dave");
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("Dave");
        assertThat(result.get(0).getAge()).isEqualTo(23);
        assertThat(result.get(0).getBloodType()).isEqualTo("A");
    }

    @Test
    void constuctorTest(){
        Person person = new Person("martin",10, "A");
    }

    @Test
    void findByBloodType(){
        List<Person> result = personRepository.findByBloodType("A");
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("benny");
    }

    @Test
    void findByMonthOfBirthday(){
        // 8월
        List<Person> result = personRepository.findByMonthOfBirthday(8);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("sophia");
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthDay) {
        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthDay));
        personRepository.save(person);
    }
}