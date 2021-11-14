package gr.codelearn.spring.movie.app.controller;

import gr.codelearn.spring.movie.app.base.AbstractLogComponent;
import gr.codelearn.spring.movie.app.domain.BaseEntity;
import gr.codelearn.spring.movie.app.service.BaseService;
import gr.codelearn.spring.movie.app.cast.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<T extends BaseEntity> extends AbstractLogComponent {
    protected abstract BaseService<T, Long> getBaseService();

    @GetMapping
    public ResponseEntity<ApiResponse<List<T>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<T>> create(@Valid @RequestBody final T entity) {
        return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(entity)).build(),
                getNoCacheHeaders(), HttpStatus.CREATED);
    }

    protected HttpHeaders getNoCacheHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return headers;
    }
}
