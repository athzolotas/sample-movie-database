package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, Long> {
    Person findByEmail(String email);

    List<Person> findAllLazy();
}
