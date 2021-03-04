package com.linktera.linkteraquiz.controller;

import com.linktera.linkteraquiz.request.BookRequest;
import com.linktera.linkteraquiz.response.BookResponse;
import com.linktera.linkteraquiz.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/getAllBooks")
    public BookResponse getBooks() throws Exception {
        return new BookResponse(bookService.getList());
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable("id") Long id) throws Exception {
        if (id == null) {
            throw new NullPointerException("id not be empty");
        }

        return new BookResponse(bookService.get(id));
    }

    @PostMapping("/saveBook")
    public void saveBook(@RequestBody BookRequest request) throws Exception {
        if (request == null || request.getBook() == null) {
            throw new NullPointerException("Book not be empty");
        }
        bookService.save(request.getBook());
    }

    @PutMapping("/{id}")
    public void updateBook(@RequestBody BookRequest request, @PathVariable("id") Long id) {
        if (request == null || request.getBook() == null || id == null) {
            throw new NullPointerException("Book or id not be empty");
        }

        bookService.merge(id, request.getBook());
    }

    @DeleteMapping("/{uuid}")
    public void deleteBook(@PathVariable("uuid") Long id) {
        if (id == null) {
            throw new NullPointerException("id not be empty");
        }

        bookService.delete(id);
    }

}
