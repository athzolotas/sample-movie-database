package gr.codelearn.spring.movie.app.repository;

import gr.codelearn.spring.movie.app.domain.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, Long> {
    @Query("select g from MovieGenre g join fetch g.movie m join fetch g.genre")
    List<MovieGenre> findAllLazy();
}
