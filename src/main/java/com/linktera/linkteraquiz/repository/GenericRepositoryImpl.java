package com.linktera.linkteraquiz.repository;

import lombok.Setter;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

@Setter
public class GenericRepositoryImpl<T> extends SimpleJpaRepository<T, Long> implements GenericRepository<T> {

    private final EntityManager em;

    public GenericRepositoryImpl(JpaEntityInformation<T, Long> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    @Override
    public T merge(T entity) {
        return em.merge(entity);
    }

}