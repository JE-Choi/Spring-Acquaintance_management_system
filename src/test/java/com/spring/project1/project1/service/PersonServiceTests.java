package com.spring.project1.project1.service;

import com.spring.project1.project1.domain.Block;
import com.spring.project1.project1.domain.Person;
import com.spring.project1.project1.repository.BlockRepository;
import com.spring.project1.project1.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTests {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    // block되지 않은 사람
    @Test
    void getPeopleExcludeBlocks() {
        // Block 사용자를 제외한 모든 사용자 추출
        List<Person> result = personService.getPeopleExcludeBlocks();
        result.forEach(System.out::println);
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("david");
        assertThat(result.get(2).getName()).isEqualTo("benny");
    }

    @Test
    void getPeopleByName(){
        List<Person> result = personService.getPeopleByName("martin");
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("martin");
    }


    @Test
    void getPerson(){
        Person result = personService.getPerson(3L);
        assertThat(result.getName()).isEqualTo("dennis");
    }


//    private void givenPerson(String name, int age, String bloodType) {
//        Person person = new Person(name, age, bloodType);
//        personRepository.save(person);
//    }

}