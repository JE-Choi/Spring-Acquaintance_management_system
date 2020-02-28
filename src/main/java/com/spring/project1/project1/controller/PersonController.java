package com.spring.project1.project1.controller;

import com.spring.project1.project1.controller.dto.PersonDto;
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

    @PutMapping("/{id}") // 수정
    // @PathVariable는 링크값으로 id값을 얻는다는 것이고
    // @RequestBody는 requestBody에 넣어진 값으로 person값을 얻는다는 의미
    public void modifyPerson(@PathVariable Long id, @RequestBody PersonDto person){
        personService.modify(id, person);
        log.info("person -> {}",personRepository.findAll());
    }

    @PatchMapping("/{id}") // 일부 부분만 update
    public void modifyPerson(@PathVariable Long id, String name){
        personService.modify(id, name);
        log.info("person -> {}",personRepository.findAll());
    }
}
