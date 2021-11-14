package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.MovieGenre;

import java.util.List;

public interface MovieGenreService extends BaseService<MovieGenre, Long> {
    List<MovieGenre> findAllLazy();
}
