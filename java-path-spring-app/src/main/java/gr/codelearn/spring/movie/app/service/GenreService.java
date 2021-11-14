package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.domain.Genre;

import java.util.List;

public interface GenreService extends BaseService<Genre, Long> {
    Genre findByName(String name);

    List<Genre> findAllLazy();
}
