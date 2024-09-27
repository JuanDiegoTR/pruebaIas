package com.example.pruebaias001.controller;

import com.example.pruebaias001.dto.ResponseDTO;
import com.example.pruebaias001.dto.VueloInDTO;
import com.example.pruebaias001.exception.CustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdvicerController.class)
class AdvicerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void customExceptionHandler() throws Exception {
        CustomException customException = new CustomException(HttpStatus.PARTIAL_CONTENT.value(), "ERROR DE PRUEBA");

        VueloInDTO vuelo = VueloInDTO.builder()
                .idReserva(1L)
                .idVuelo(1L)
                .idTiquete(1L)
                .ciudad("Neivas")
                .idUsuario(1L)
                .build();

        String request = objectMapper.writeValueAsString(vuelo);

        ResponseDTO responseDTO = ResponseDTO.builder()
                .data(Collections.emptyMap())
                .status(HttpStatus.PARTIAL_CONTENT.value())
                .message("ERROR DE PRUEBA")
                .build();

        String response = objectMapper.writeValueAsString(responseDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/airline")
                        .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isPartialContent());
    }

}