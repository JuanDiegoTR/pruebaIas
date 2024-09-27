package com.example.pruebaias001.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final int httpStatus;
    private final String message;

}
