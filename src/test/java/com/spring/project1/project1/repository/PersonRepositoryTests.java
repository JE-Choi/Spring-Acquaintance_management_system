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

    @Test
    void findByBloodType(){
        givenPeople();
        List<Person> result = personRepository.findByBloodType("A");
        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween(){
        givenPeople();
        // 1991-08-01이상~ 08-31이하
        List<Person> result = personRepository.findByBirthdayBetween(LocalDate.of(1991, 8,1), LocalDate.of(1991, 8,31));
        result.forEach(System.out::println);
    }

    private void givenPeople() {
        givenPerson("martin",10,"A", LocalDate.of(1991,8,3));
        givenPerson("drtin",9,"B", LocalDate.of(1991,8,28));
        givenPerson("cytin",7,"O", LocalDate.of(1992,7,3));
        givenPerson("martin",11,"AB", LocalDate.of(1993,6,3));
        givenPerson("giny",9,"A", LocalDate.of(1995,8,10));
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthDay) {
        Person person = new Person(name, age, bloodType);
        person.setBirthday(birthDay);
        personRepository.save(person);
    }
}