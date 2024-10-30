package com.hexagonalddd.bookstore.infrastructure.adapters.outbound.persistence;

import com.hexagonalddd.bookstore.application.ports.outbound.IBookOutOperations;
import com.hexagonalddd.bookstore.domain.entities.Book;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class BookJPAAdapter implements IBookOutOperations {

    @Autowired
    private BookJPARepository bookRepository;

    @Override
    public Optional<Book> findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    @Override
    public Book save(Book book) {
        Book bookSaved = bookRepository.save(book);
        return bookSaved;
    }

    @Override
    public Book modify(Book book) {
        Book bookModified = bookRepository.save(book);
        return bookModified;
    }

    @Override
    public Boolean deleteById(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
