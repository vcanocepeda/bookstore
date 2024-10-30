package com.hexagonalddd.bookstore.infrastructure.adapters.outbound.rest;

import com.hexagonalddd.bookstore.application.ports.outbound.IExternalOperations;
import com.hexagonalddd.bookstore.domain.entities.Comment;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class FeignAPIClientAdapter implements IExternalOperations {

    @Autowired
    private FeignAPIClient feignClient;

 /*   public FeignAPIClientAdapter(FeignAPIClient feignClient) {
        this.feignClient = feignClient;
    } */

    @Override
    public List<Comment> getAllComments() {
        List<Comment> commentList = feignClient.getAllComments();
        return commentList;
    }
}
