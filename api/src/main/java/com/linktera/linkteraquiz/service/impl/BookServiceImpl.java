package com.linktera.linkteraquiz.service.impl;

import com.linktera.linkteraquiz.model.Book;
import com.linktera.linkteraquiz.repository.BookRepository;
import com.linktera.linkteraquiz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Throwable.class)
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getList() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public Book merge(Long id,Book entity) {
        Book existEntity = bookRepository.getOne(id);
        if(existEntity.getId() != null && entity != null){
            return bookRepository.merge(entity);
        } else{
            return bookRepository.saveAndFlush(entity);
        }
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
