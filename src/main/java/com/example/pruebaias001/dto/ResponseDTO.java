package com.example.pruebaias001.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDTO {

    private Object data;
    private int status;
    private String message;
}
