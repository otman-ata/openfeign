package hu.me.iit.distributedsystems.openfeignclient;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("neptun")
public interface PeopleClient {

    @GetMapping(path="people", produces= MediaType.APPLICATION_JSON_VALUE)
    List<PeopleDto> getAllPeople();
    @PostMapping(path="people")
    void createPerson(@RequestBody @Valid PeopleDto peopleDto);
    @PutMapping(path="people/")
    void updatePerson(@RequestBody @Valid PeopleDto peopleDto);
    @DeleteMapping(path="people/{id}")
    void  deletePerson(@PathVariable("id") Long id);


}
