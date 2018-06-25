package org.learning.springboot.graphql.controller.books;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.springboot.graphql.controller.rest.BooksController;
import org.learning.springboot.graphql.entity.Book;
import org.learning.springboot.graphql.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = BooksController.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = { "org.learning.springboot.graphql"})
public class BooksControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private BooksRepository booksRepository;


    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addBooks() throws Exception{
Book book=new Book();
book.setPrice(new BigDecimal(123));
book.setName("Spring Boot");
        mockMvc.perform(post("/addbook")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(book)))
                .andExpect(status().isOk());

    }

    @Test
    public void getBooks() throws Exception{
        mockMvc.perform(get("/getbooks")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$[0].name","Spring Boot").isString());

    }

}
