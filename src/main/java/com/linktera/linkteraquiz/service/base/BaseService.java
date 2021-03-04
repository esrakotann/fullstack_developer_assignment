package com.linktera.linkteraquiz.service.base;

import java.util.List;

public interface BaseService<T> {

    List<T> getList() throws Exception;
    T get(Long id) throws Exception;
    void save(T entity) throws Exception;
    T merge(Long id,T entity) throws Exception;
    void delete(Long id) throws Exception;

}
