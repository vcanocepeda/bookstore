package com.hexagonalddd.bookstore.application.ports.outbound;

import com.hexagonalddd.bookstore.domain.entities.Comment;
import java.util.List;

public interface IExternalOperations {

    public List<Comment> getAllComments();
}
