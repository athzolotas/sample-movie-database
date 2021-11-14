package gr.codelearn.spring.movie.app.controller;

import gr.codelearn.spring.movie.app.domain.Movie;
import gr.codelearn.spring.movie.app.service.BaseService;
import gr.codelearn.spring.movie.app.service.MovieService;
import gr.codelearn.spring.movie.app.cast.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController extends AbstractController<Movie> {
    private final MovieService movieService;

    @Override
    public BaseService<Movie, Long> getBaseService() {
        return movieService;
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Movie>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findAllLazy()).build());
    }
}
