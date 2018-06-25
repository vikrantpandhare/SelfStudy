package org.learning.springboot.graphql.repository;

import org.learning.springboot.graphql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Book,Integer> {
}
