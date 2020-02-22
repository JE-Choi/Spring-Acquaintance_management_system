package com.spring.project1.project1.service;

import com.spring.project1.project1.domain.Block;
import com.spring.project1.project1.domain.Person;
import com.spring.project1.project1.repository.BlockRepository;
import com.spring.project1.project1.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTests {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {
        givenPeople(); // 사용자 Jpa에 저장
        givenBlocks(); // Block 사용자 Jpa에 저장

        // Block 사용자를 제외한 모든 사용자 추출
        List<Person> result = personService.getPeopleExcludeBlocks();
//        System.out.println(result);
        result.forEach(System.out::println);
    }

    private void givenPeople() {
        givenPerson("martin",10,"A");
        givenPerson("drtin",9,"B");
        givenPerson("cytin",7,"O");
        givenPerson("martin",11,"AB");
    }

    private void givenBlocks() {
        givenBlock("martin");
    }

    private void givenPerson(String name, int age, String bloodType) {
        Person person = new Person(name, age, bloodType);
        personRepository.save(person);
    }

    private void givenBlock(String name) {
        Block block = new Block(name);
        blockRepository.save(block);
    }
}