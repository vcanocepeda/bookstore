package com.hexagonalddd.bookstore.infrastructure.adapters.outbound.persistence;

import com.hexagonalddd.bookstore.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJPARepository extends JpaRepository<Book, Long> {

}
