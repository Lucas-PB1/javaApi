package com.apiexample.controllers;

import com.apiexample.models.Person;
import com.apiexample.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable int id) throws Exception{
        return services.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> listPerson() throws Exception{
        return services.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) throws Exception{
        return services.create(person);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) throws Exception{
        return services.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable int id) throws Exception{
        return services.delete(id);
    }
}
