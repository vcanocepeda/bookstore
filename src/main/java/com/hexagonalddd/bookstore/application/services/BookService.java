package com.hexagonalddd.bookstore.application.services;

import com.hexagonalddd.bookstore.application.ports.outbound.IExternalOperations;
import com.hexagonalddd.bookstore.domain.entities.Book;
import com.hexagonalddd.bookstore.application.dtos.BookDTO;
import com.hexagonalddd.bookstore.application.ports.outbound.IBookOutOperations;
import com.hexagonalddd.bookstore.domain.entities.Comment;
import com.hexagonalddd.bookstore.domain.exceptions.BookNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final IBookOutOperations bookJPAAdapter;

    private final IExternalOperations feignAPIClientAdapter;

    public BookDTO getBookById(String id) {
        Optional<Book> optionalBook = bookJPAAdapter.findById(Long.valueOf(id));
        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException(HttpStatus.NOT_FOUND.toString(), "Book with id: " + id + " not found");
        }
        Book book = optionalBook.get();
        List<Comment> commentList = feignAPIClientAdapter.getAllComments();
        return new BookDTO(String.valueOf(book.getId()), book.getTitle(), book.getAuthor());
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = new Book(Integer.parseInt(bookDTO.getId()), bookDTO.getTitle(), bookDTO.getAuthor());
        Book savedBook = bookJPAAdapter.save(book);
        bookDTO = new BookDTO(String.valueOf(savedBook.getId()), savedBook.getTitle(), savedBook.getAuthor());
        log.info("Book with id: {} saved successfully", bookDTO.getId());
        return bookDTO;
    }

    public BookDTO modifyBook(BookDTO bookDTO) {
        Optional<Book> existingBook = bookJPAAdapter.findById(Long.parseLong(bookDTO.getId()));
        if (existingBook.isEmpty()) {
            throw new BookNotFoundException(HttpStatus.NOT_FOUND.toString(), "Book with id: " + bookDTO.getId() + " not found");
        }
        Book book = new Book(Integer.parseInt(bookDTO.getId()), bookDTO.getTitle(), bookDTO.getAuthor());
        Book bookModified = bookJPAAdapter.modify(book);
        bookDTO = new BookDTO(String.valueOf(bookModified.getId()), bookModified.getTitle(), bookModified.getAuthor());
        log.info("Book with id: {} updated successfully", bookDTO.getId());
        return bookDTO;
    }

    public Boolean deleteBookById(String id) {
        return bookJPAAdapter.deleteById(Long.valueOf(id));
    }
}
