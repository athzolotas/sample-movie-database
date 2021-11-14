package gr.codelearn.spring.movie.app.service;

import gr.codelearn.spring.movie.app.base.AbstractLogComponent;
import gr.codelearn.spring.movie.app.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class AbstractService<T extends BaseEntity> extends AbstractLogComponent
        implements BaseService<T, Long> {
    public abstract JpaRepository<T, Long> getRepository();

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<T> createAll(final T... entities) {
        return createAll(Arrays.asList(entities));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<T> createAll(final List<T> entities) {
        final List<T> updatedEntities = new ArrayList<>();
        for (final T entity : entities) {
            updatedEntities.add(create(entity));
        }
        return updatedEntities;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public T create(final T entity) {
        logger.trace("Creating {}.", entity);
        return getRepository().save(entity);
    }

    @Override
    public List<T> findAll() {
        logger.trace("Retrieving all entities.");
        return getRepository().findAll();
    }

    @Override
    public T find(Long id) {
        return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
    }
}
