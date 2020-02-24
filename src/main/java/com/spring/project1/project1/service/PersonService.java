package com.spring.project1.project1.service;

import com.spring.project1.project1.domain.Block;
import com.spring.project1.project1.domain.Person;
import com.spring.project1.project1.repository.BlockRepository;
import com.spring.project1.project1.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks(){
//        List<Person> people = personRepository.findAll();
//        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
        return personRepository.findByBlockIsNull();
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
//        Person person = personRepository.findById(id).get();
        /*
        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()){
            log.info("person : {}", person);
            return person.get();
        } else{
            return null;
        }
        또는 !!!
        */
        // 값이 없으면 null로
        Person person = personRepository.findById(id).orElse(null);
        log.info("person : {}", person);
        return person;
    }

    public List<Person> getPeopleByName(String name) {
//        List<Person> people = personRepository.findAll();
//        return people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
        return personRepository.findByName(name);
    }
}
