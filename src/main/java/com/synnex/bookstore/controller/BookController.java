package com.synnex.bookstore.controller;

import com.synnex.bookstore.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @PostMapping("/books")
    public ResponseEntity<String> createBook(@Validated @RequestBody Book book) {
        // Process the validated book object
        return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully");
    }

}
