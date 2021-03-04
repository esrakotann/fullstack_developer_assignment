package com.linktera.linkteraquiz.service.impl;

import com.linktera.linkteraquiz.model.Customer;
import com.linktera.linkteraquiz.model.Person;
import com.linktera.linkteraquiz.repository.CustomerRepository;
import com.linktera.linkteraquiz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> getList() throws Exception {
        return repository.findAll();
    }

    @Override
    public Customer get(Long id) throws Exception {
        return null;
    }

    @Override
    public void save(Customer entity) throws Exception {

    }

    @Override
    public Customer merge(Long id, Customer entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
