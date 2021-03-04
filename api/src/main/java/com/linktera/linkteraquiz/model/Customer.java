package com.linktera.linkteraquiz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter
public class Customer extends Person{

    @OneToMany(mappedBy= "customer", fetch = FetchType.LAZY)
    private List<Book> books;
}
