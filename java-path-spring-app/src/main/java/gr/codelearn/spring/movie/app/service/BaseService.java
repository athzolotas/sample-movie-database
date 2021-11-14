package gr.codelearn.spring.movie.app.service;

import java.util.List;

public interface BaseService<T, ID> {
    T create(T entity);

    List<T> createAll(List<T> entities);

    List<T> createAll(T... entities);

    T find(ID id);

    List<T> findAll();
}
