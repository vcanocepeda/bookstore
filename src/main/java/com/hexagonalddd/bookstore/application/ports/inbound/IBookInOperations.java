package com.hexagonalddd.bookstore.application.ports.inbound;

import com.hexagonalddd.bookstore.application.dtos.BookDTO;

public interface IBookInOperations {

    public BookDTO get(String id);

    public BookDTO save(BookDTO book);

    public BookDTO modify(BookDTO book);

    public Boolean delete(String id);
}
