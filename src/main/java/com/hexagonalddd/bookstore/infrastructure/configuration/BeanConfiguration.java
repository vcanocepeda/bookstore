package com.hexagonalddd.bookstore.infrastructure.configuration;

import com.hexagonalddd.bookstore.application.ports.inbound.IBookInOperations;
import com.hexagonalddd.bookstore.application.ports.outbound.IBookOutOperations;
import com.hexagonalddd.bookstore.application.services.BookService;
import com.hexagonalddd.bookstore.infrastructure.adapters.inbound.rest.BookRestAdapter;
import com.hexagonalddd.bookstore.infrastructure.adapters.outbound.persistence.BookJPAAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    IBookInOperations bookRestAdapter(BookService bookService) {
        return new BookRestAdapter(bookService);
    }

    @Bean
    IBookOutOperations bookJPAAdapter() {
        return new BookJPAAdapter();
    }
}
