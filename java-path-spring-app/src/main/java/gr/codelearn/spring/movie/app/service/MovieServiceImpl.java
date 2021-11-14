package gr.codelearn.spring.movie.app.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.codelearn.spring.movie.app.domain.Movie;
import gr.codelearn.spring.movie.app.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends AbstractService<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public Movie findByTitle(final String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> findAllLazy() {
        return movieRepository.findAllLazy();
    }
}

