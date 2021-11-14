package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.MovieCast;

import java.util.List;

public interface MovieCastService extends BaseService<MovieCast, Long> {
    List<MovieCast> findAllLazy();
}
