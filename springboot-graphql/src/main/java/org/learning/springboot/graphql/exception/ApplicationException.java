package org.learning.springboot.graphql.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
public class ApplicationException {
private HttpStatus httpStatus;
private String message;
private List<String> errors;

    public ApplicationException(HttpStatus httpStatus, String message, List<String> errors) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }


    public ApplicationException(HttpStatus httpStatus, String localizedMessage, String errors) {
        super();
        this.httpStatus = httpStatus;
        this.message = localizedMessage;
        this.errors = Arrays.asList(errors);
    }
}
