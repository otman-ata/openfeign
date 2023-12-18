package com.example.Neptun;

import Entity.Person;
import Repository.Repository;
import Service.Service;
import Controller.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class NeptunApplication {

	public static void main(String[] args) {
		Repository Repository = new Repository();
		Service Service = new Service(Repository);
		Controller personController = new Controller(Service);

		// Example usage
		Person person = new Person();
		person.setName("OTMAN ATANANE");
		person.setAge(25);

		personController.createPerson(person);
		List<Person> allPeople = (List<Person>) personController.getAllPeople();
		System.out.println("All People: " + allPeople);

		Long personId = allPeople.get(0).getId();
		Person retrievedPerson = personController.getPerson(personId).getBody();
		System.out.println("Retrieved Person: " + retrievedPerson);

		retrievedPerson.setAge(30);
		Person updatedPerson = personController.updatePerson(personId, retrievedPerson).getBody();
		System.out.println("Updated Person: " + updatedPerson);

		personController.deletePerson(personId);
		List<Person> remainingPeople = (List<Person>) personController.getAllPeople();
		System.out.println("Remaining People: " + remainingPeople);
	}

}
