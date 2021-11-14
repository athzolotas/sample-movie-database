package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
    Movie findByTitle(String title);

    List<Movie> findAllLazy();
}
