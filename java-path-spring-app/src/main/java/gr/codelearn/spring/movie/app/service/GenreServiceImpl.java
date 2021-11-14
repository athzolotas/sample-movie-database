package gr.codelearn.spring.movie.app.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.repository.JpaRepository;
import gr.codelearn.spring.movie.app.domain.Genre;
import gr.codelearn.spring.movie.app.repository.GenreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl extends AbstractService<Genre> implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public JpaRepository<Genre, Long> getRepository() {
        return genreRepository;
    }

    @Override
    public Genre findByName(final String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public List<Genre> findAllLazy() {
        return genreRepository.findAllLazy();
    }
}

