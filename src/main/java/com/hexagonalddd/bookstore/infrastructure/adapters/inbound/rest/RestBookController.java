package com.hexagonalddd.bookstore.infrastructure.adapters.inbound.rest;

import com.hexagonalddd.bookstore.application.dtos.BookDTO;
import com.hexagonalddd.bookstore.application.ports.inbound.IBookInOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book/v1")
@RestController
public class RestBookController {

    @Autowired
    private IBookInOperations bookRestAdapter;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO get(@PathVariable String id) {
        BookDTO bookDTO = bookRestAdapter.get(id);
        return bookDTO;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO save(@RequestBody BookDTO book) {
        BookDTO bookDTO = bookRestAdapter.save(book);
        return bookDTO;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO modify(@RequestBody BookDTO book) {
        return null;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean delete(@PathVariable String id) {
        Boolean result = bookRestAdapter.delete(id);
        return result;
    }
}
