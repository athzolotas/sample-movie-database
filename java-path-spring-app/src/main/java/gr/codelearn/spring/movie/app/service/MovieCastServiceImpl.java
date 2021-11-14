package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.Person;
import gr.codelearn.spring.movie.app.domain.Movie;
import gr.codelearn.spring.movie.app.domain.MovieCast;
import gr.codelearn.spring.movie.app.repository.MovieCastRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCastServiceImpl extends AbstractService<MovieCast> implements MovieCastService {
    private final MovieCastRepository movieCastRepository;

    @Override
    public JpaRepository<MovieCast, Long> getRepository() {
        return movieCastRepository;
    }

    @Override
    public List<MovieCast> findAllLazy() {
        return movieCastRepository.findAllLazy();
    }
}

