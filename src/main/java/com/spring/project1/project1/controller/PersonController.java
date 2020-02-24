package com.spring.project1.project1.controller;

import com.spring.project1.project1.domain.Person;
import com.spring.project1.project1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
public class PersonController {
    @Autowired
    PersonService personService;

//    @RequestMapping(method = RequestMethod.GET) "★★★또는★★★"
    @GetMapping
    // url의 특정 위치에 있는 값을 PathVariable로 받겠다는 의미.
    @RequestMapping(value = "/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }
}
