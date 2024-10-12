package com.hexagonalddd.bookstore.application.services;

import com.hexagonalddd.bookstore.domain.entities.Book;
import com.hexagonalddd.bookstore.application.dtos.BookDTO;
import com.hexagonalddd.bookstore.application.ports.outbound.IBookOutOperations;
import com.hexagonalddd.bookstore.domain.exceptions.BookNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

   // @Autowired
    private final IBookOutOperations bookJPAAdapter;

    public BookDTO getBook(String id) {
        Optional<Book> optionalBook = bookJPAAdapter.get(Long.valueOf(id));
        if (optionalBook.isEmpty()) throw new BookNotFoundException(HttpStatus.NOT_FOUND.toString(),"Book not found");
        Book book = optionalBook.get();
        return new BookDTO(String.valueOf(book.getId()), book.getTitle(), book.getAuthor());
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = new Book (Long.parseLong(bookDTO.getId()), bookDTO.getTitle(), bookDTO.getAuthor());
        Book bookSaved = bookJPAAdapter.save(book);
        bookDTO = new BookDTO(String.valueOf(bookSaved.getId()), bookSaved.getTitle(), bookSaved.getAuthor());
        return bookDTO;
    }

    public BookDTO modifyBook(BookDTO bookDTO) {
        Book book = new Book (Long.parseLong(bookDTO.getId()), bookDTO.getTitle(), bookDTO.getAuthor());
        Book bookModified = bookJPAAdapter.modify(book);
        bookDTO = new BookDTO(String.valueOf(bookModified.getId()), bookModified.getTitle(), bookModified.getAuthor());
        return bookDTO;
    }

    public Boolean deleteBook(String id) {
        Boolean result = bookJPAAdapter.delete(Long.valueOf(id));
        return result;
    }

}
