package com.hexagonalddd.bookstore.infrastructure.adapters.outbound.rest;

import com.hexagonalddd.bookstore.domain.entities.Comment;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${external.feign-client.name}", url = "${external.feign-client.url}")
public interface FeignAPIClient {

    @GetMapping
    List<Comment> getAllComments();
}
