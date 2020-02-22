package com.spring.project1.project1.repository;

import com.spring.project1.project1.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();
        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("Dave");
        assertThat(people.get(0).getAge()).isEqualTo(23);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");
    }

//    @Test
//    void allArgsConstructor(){
//        Person person = new Person(1L, "martin", 10, "reading", "A", "분당", LocalDate.of(2019,1,1), "programmer", "010-1234-1234");
//    }

    @Test
    void constuctorTest(){
        Person person = new Person("martin",10, "A");
    }

    @Test
    void hashCodeAndEquals(){
        Person person1 = new Person("martin", 10, "A");
        Person person2 = new Person("martin", 10, "A");
        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person1.getAge());
        System.out.println(map);
        System.out.println(map.get(person2));
    }
}