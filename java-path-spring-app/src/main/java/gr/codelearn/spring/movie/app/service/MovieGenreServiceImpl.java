package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.Genre;
import gr.codelearn.spring.movie.app.domain.Movie;
import gr.codelearn.spring.movie.app.domain.MovieGenre;
import gr.codelearn.spring.movie.app.repository.MovieGenreRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieGenreServiceImpl extends AbstractService<MovieGenre> implements MovieGenreService {
    private final MovieGenreRepository movieGenreRepository;

    @Override
    public JpaRepository<MovieGenre, Long> getRepository() {
        return movieGenreRepository;
    }

    @Override
    public List<MovieGenre> findAllLazy() {
        return movieGenreRepository.findAllLazy();
    }
}

