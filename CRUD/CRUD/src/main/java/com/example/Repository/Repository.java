package com.example.Repository;

import com.example.Entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class Repository {
    private final List<Person> people = new ArrayList<>();
    private long idCounter = 1;

    public Person save(Person person) {
        if (person.getId() == null) {
            person.setId(idCounter++);
        }
        people.add(person);
        return person;
    }

    public List<Person> findAll() {
        return new ArrayList<>(people);
    }

    public Optional<Person> findById(Long id) {
        return people.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        people.removeIf(person -> person.getId().equals(id));
    }
}
