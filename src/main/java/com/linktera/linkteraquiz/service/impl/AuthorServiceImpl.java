package com.linktera.linkteraquiz.service.impl;

import com.linktera.linkteraquiz.model.Author;
import com.linktera.linkteraquiz.repository.AuthorRepository;
import com.linktera.linkteraquiz.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository repository;

    @Override
    public List<Author> getList() throws Exception {
        return repository.findAll();
    }

    @Override
    public Author get(Long id) throws Exception {
        return repository.getOne(id);
    }

    @Override
    public void save(Author entity) throws Exception {
        repository.saveAndFlush(entity);
    }

    @Override
    public Author merge(Long id, Author entity) throws Exception {
        Author existEntity = repository.getOne(id);
        if(existEntity.getId() != null && entity != null){
            return repository.merge(entity);
        } else{
            return repository.saveAndFlush(entity);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
            repository.deleteById(id);
    }
}
