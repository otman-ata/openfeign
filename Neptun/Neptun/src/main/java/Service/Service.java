package Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
