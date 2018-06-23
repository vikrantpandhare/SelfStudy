package org.learning.springboot.graphql.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.springboot.graphql.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CustomRestExceptionHandler.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = { "org.learning.springboot.graphql"})
public class CustomRestExceptionTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void handleAllExceptionTest() throws Exception {

        Books book=new Books();
        book.setPrice(new BigDecimal(123));
       // book.setName("Spring Boot");

        mockMvc.perform(get("/getexception")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isInternalServerError());
    }
}
