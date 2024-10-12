package com.hexagonalddd.bookstore.infrastructure.adapters.inbound.rest;

import com.hexagonalddd.bookstore.application.dtos.BookDTO;
import com.hexagonalddd.bookstore.application.ports.inbound.IBookInOperations;
import com.hexagonalddd.bookstore.application.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class BookRestAdapter implements IBookInOperations {

    @Autowired
    private final BookService bookService;

    @Override
    public BookDTO get(String id) {
        return bookService.getBook(id);
    }

    @Override
    public BookDTO save(BookDTO book) {
        BookDTO bookDTO = bookService.saveBook(book);
        return bookDTO;
    }

    @Override
    public BookDTO modify(BookDTO book) {
        BookDTO bookDTO = bookService.modifyBook(book);
        return bookDTO;
    }

    @Override
    public Boolean delete(String id) {
        return bookService.deleteBook(id);
    }
}
