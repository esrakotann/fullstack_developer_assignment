package com.linktera.linkteraquiz.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.linktera.linkteraquiz.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @JsonProperty("book")
    private Book book;

}
