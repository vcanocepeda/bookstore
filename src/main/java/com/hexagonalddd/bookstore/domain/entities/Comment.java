package com.hexagonalddd.bookstore.domain.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    private int postId;

    @Id
    private int id;

    private String name;

    private String email;

    private String body;
}
