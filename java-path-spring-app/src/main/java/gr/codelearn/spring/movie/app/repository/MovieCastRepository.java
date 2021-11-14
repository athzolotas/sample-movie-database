package gr.codelearn.spring.movie.app.repository;

import gr.codelearn.spring.movie.app.domain.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCastRepository extends JpaRepository<MovieCast, Long> {
    @Query("select r from MovieCast r join fetch r.person join fetch r.movie")
    List<MovieCast> findAllLazy();
}
