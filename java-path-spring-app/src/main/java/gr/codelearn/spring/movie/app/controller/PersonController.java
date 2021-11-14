package gr.codelearn.spring.movie.app.controller;

import gr.codelearn.spring.movie.app.domain.Person;
import gr.codelearn.spring.movie.app.service.BaseService;
import gr.codelearn.spring.movie.app.service.PersonService;
import gr.codelearn.spring.movie.app.cast.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    @Override
    public BaseService<Person, Long> getBaseService() {
        return personService;
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Person>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Person>>builder().data(personService.findAllLazy()).build());
    }
}
