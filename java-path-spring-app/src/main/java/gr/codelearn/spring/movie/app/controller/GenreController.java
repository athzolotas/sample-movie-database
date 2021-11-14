package gr.codelearn.spring.movie.app.controller;

import gr.codelearn.spring.movie.app.domain.Genre;
import gr.codelearn.spring.movie.app.service.BaseService;
import gr.codelearn.spring.movie.app.service.GenreService;
import gr.codelearn.spring.movie.app.cast.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController extends AbstractController<Genre> {
    private final GenreService genreService;

    @Override
    public BaseService<Genre, Long> getBaseService() {
        return genreService;
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Genre>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Genre>>builder().data(genreService.findAllLazy()).build());
    }
}
