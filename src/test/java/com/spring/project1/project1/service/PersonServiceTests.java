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
//        givenBlocks(); // Block 사용자 Jpa에 저장

        // Block 사용자를 제외한 모든 사용자 추출
        List<Person> result = personService.getPeopleExcludeBlocks();
//        System.out.println(result);
        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest(){
        givenPeople();
        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        // 다시 person 저장소에 저장해야지, 변경된 people 객체가 저장됨.
        // CascadeType.MERGE가 지정되어있어야 한다.
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

        // CascadeType.REMOVE 지정되어있어야 한다.
//        personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockRepository.findAll().forEach(System.out::println);

        // block을 null로 재 설정 후 저장
        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        // block이 null이 되었는데도, 고아 객체가 안 없어짐.
        blockRepository.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson(){
        givenPeople();
        Person person = personService.getPerson(3L);
    }

    private void givenPeople() {
        givenPerson("martin",10,"A");
        givenPerson("drtin",9,"B");
        givenBlockPerson("cytin",7,"O");
        givenBlockPerson("martin",11,"AB");
    }

//    private void givenBlocks() {
//        givenBlock("martin");
//    }

    private void givenPerson(String name, int age, String bloodType) {
        Person person = new Person(name, age, bloodType);
        personRepository.save(person);
    }

    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
//        blockPerson.setBlock(givenBlock(name));
        // givenBlock으로 block생성 안하면, 저장소에 저장되지 않은 객체라는 에러가 뜨는데, 그걸 cascadeType.persist가 해결해준다.
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);
    }

//    private Block givenBlock(String name) {
//        Block block = new Block(name);
//        return blockRepository.save(block);
//    }
}