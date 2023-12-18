package com.example.Neptun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
@Service
@Controller
@SpringBootApplication
public class NeptunApplication {

	public static void main(String[] args) {
		Repository personRepository = new Repository();
		Service personService = new Service(Repository);
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
