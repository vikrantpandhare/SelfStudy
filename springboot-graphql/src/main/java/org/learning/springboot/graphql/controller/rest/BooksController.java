package org.learning.springboot.graphql.controller.rest;

import org.learning.springboot.graphql.entity.Book;
import org.learning.springboot.graphql.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/rest")
public class BooksController {
    @Autowired
    BooksRepository booksRepository;

    @PostMapping("/addbook")
    public ResponseEntity<String> addBooks(@RequestBody Book book) {
        booksRepository.save(book);
        return new ResponseEntity<>("Saved", HttpStatus.OK);

    }

    @GetMapping("/getbooks")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(booksRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getexception")
    public ResponseEntity<List<Book>> getException() throws Exception {
        throw new Exception("Exception");
    }
}
