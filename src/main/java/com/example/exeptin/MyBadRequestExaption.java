package com.example.exeptin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
public class MyBadRequestExaption extends RuntimeException {

    String message;


    public MyBadRequestExaption(String message) {
        this.message = message;
    }

}
