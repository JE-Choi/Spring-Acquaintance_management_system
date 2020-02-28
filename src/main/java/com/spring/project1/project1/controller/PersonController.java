package com.spring.project1.project1.controller;

import com.spring.project1.project1.domain.Person;
import com.spring.project1.project1.repository.PersonRepository;
import com.spring.project1.project1.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;

//    @RequestMapping(method = RequestMethod.GET) "★★★또는★★★"
    @GetMapping("/{id}")
    // url의 특정 위치에 있는 값을 PathVariable로 받겠다는 의미.
//    @RequestMapping(value = "/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPerson(@RequestBody Person person){ // get이 아니라 requestBody에 넣어서 post로 보낸다는 의미
        personService.put(person);
        log.info("person -> {}" , personRepository.findAll());
    }
}
