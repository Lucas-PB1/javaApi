package com.apiexample.services;

import com.apiexample.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(int id){
        logger.info("Find register for id: " + id);
        return mockPerson((int) counter.incrementAndGet());
    }

    public List<Person> findAll(){
        logger.info("Find all registers");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person create(Person person){
        logger.info("Create register: " + person);
        return person;
    }

    public Person update(Person person){
        logger.info("Update register: " + person);
        return person;
    }

    public String delete(int id){
        logger.info("Deleting this register: " + id);
        return "Registro Deletado: " + id;
    }

    private Person mockPerson(int i) {
        Person person;
        person = new Person();

        person.setId(i);
        person.setName("Lucas");
        person.setAddress("João Pessoa, Paraíba");
        person.setEmail("lucasoaresnet@gmail.com");
        person.setPhone("83996227670");

        return person;
    }
}
