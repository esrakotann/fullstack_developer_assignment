package com.linktera.linkteraquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T,Long> {

    T merge(T entity);

}


