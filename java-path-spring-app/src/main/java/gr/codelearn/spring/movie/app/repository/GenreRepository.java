package gr.codelearn.spring.movie.app.repository;

import gr.codelearn.spring.movie.app.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);

    @Query("select distinct g from Genre g join fetch g.movieGenres m join fetch m.movie o join fetch o.movieCasts c join fetch c.person")
    List<Genre> findAllLazy();
}
