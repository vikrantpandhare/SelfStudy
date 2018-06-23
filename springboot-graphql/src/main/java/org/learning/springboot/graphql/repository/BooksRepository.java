package org.learning.springboot.graphql.repository;

import org.learning.springboot.graphql.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Books,Integer> {
}
