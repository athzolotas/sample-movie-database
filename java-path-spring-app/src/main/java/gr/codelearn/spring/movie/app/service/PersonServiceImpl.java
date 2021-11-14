package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.Person;
import gr.codelearn.spring.movie.app.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends AbstractService<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public Person findByEmail(final String email) {
        return personRepository.findAll().stream().filter(c -> c.getEmail().equals(email)).findAny().orElse(null);
    }

    @Override
    public List<Person> findAllLazy() {
        return personRepository.findAllLazy();
    }
}
