package com.example.pruebaias001.controller;

import com.example.pruebaias001.dto.ResponseDTO;
import com.example.pruebaias001.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Objects;

@RestControllerAdvice
public class AdvicerController {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ResponseDTO> customExceptionHandler(CustomException customException){

        if (Objects.equals(customException.getHttpStatus(), HttpStatus.PARTIAL_CONTENT.value())){
            return new ResponseEntity<>(ResponseDTO.builder()
                    .data(Collections.emptyMap())
                    .message(customException.getMessage())
                    .status(customException.getHttpStatus())
                    .build(), HttpStatus.PARTIAL_CONTENT);
        }
        return new ResponseEntity<>(ResponseDTO.builder()
                .data(Collections.emptyMap())
                .message(customException.getMessage())
                .status(customException.getHttpStatus())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
