package com.hexagonalddd.bookstore.application.ports.outbound;

import com.hexagonalddd.bookstore.domain.entities.Book;
import java.util.Optional;

public interface IBookOutOperations {

    public Optional<Book> get(Long id);

    public Book save(Book book);

    public Book modify(Book book);

    public Boolean delete(Long id);
}
