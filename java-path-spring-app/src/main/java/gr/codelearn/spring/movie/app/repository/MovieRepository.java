package gr.codelearn.spring.movie.app.repository;

import gr.codelearn.spring.movie.app.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);

    @Query("select distinct m from Movie m join fetch m.movieCasts r join fetch r.person join fetch m.movieGenres g join fetch g.genre")
    List<Movie> findAllLazy();
}
