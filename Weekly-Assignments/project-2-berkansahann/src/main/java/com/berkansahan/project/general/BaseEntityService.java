package com.berkansahan.project.general;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

    private final R repository;

    public E save(E entity) {
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        if (baseAdditionalFields == null) {
            baseAdditionalFields = new BaseAdditionalFields();
        }

        if (entity.getId() == null) {
            baseAdditionalFields.setCreatedDate(LocalDateTime.now());
            baseAdditionalFields.setCreatedBy(1L);
        } else {
            baseAdditionalFields.setUpdatedDate(LocalDateTime.now());
            baseAdditionalFields.setUpdatedBy(1L);
        }

        entity.setBaseAdditionalFields(baseAdditionalFields);
        entity = repository.save(entity);
        return entity;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E findByIdWithControl(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public boolean isExist(Long id) {
        return repository.existsById(id);
    }
}
