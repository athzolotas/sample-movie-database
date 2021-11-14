package gr.codelearn.spring.movie.app.repository;

import gr.codelearn.spring.movie.app.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);

    @Query("select distinct p from Person p join fetch p.movieCasts r join fetch r.movie m join fetch m.movieGenres g join fetch g.genre")
    List<Person> findAllLazy();
}
