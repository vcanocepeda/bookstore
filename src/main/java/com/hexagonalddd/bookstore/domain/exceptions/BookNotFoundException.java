package com.hexagonalddd.bookstore.domain.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookNotFoundException extends RuntimeException {

    private final String code;
    private final String message;

    public BookNotFoundException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
