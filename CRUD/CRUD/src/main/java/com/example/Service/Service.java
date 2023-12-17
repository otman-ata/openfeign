package com.example.Service;

import com.example.Entity.Person;
import com.example.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@org.springframework.stereotype.Service
public class Service {
    private final Repository personRepository;

    @Autowired
    public Service(Repository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }
}
