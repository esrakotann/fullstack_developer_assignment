package com.linktera.linkteraquiz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
