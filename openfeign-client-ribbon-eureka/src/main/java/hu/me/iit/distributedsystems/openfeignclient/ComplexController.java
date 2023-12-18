package hu.me.iit.distributedsystems.openfeignclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ComplexController {
    private static final int AGE_LIMIT = 100;
    private final PeopleClient peopleClient;

    @GetMapping("getAllPeople")
    List<ArticleDto> getAllPeople() {
        return peopleClient.getAllPeople().stream()
                .filter(people -> people.getAge() > AGE_LIMIT)
                .toList();
    }
}
