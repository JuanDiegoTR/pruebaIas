package com.example.pruebaias001.controller;

import com.example.pruebaias001.dto.ResponseDTO;
import com.example.pruebaias001.dto.VueloInDTO;
import com.example.pruebaias001.service.ReservaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ReservaControllerTest {

    @Mock
    ReservaService reservaService;

    @InjectMocks
    ReservaController reservaController;

    @Test
    void findByReserva() {

        Mockito.when(reservaService.findByReserva(any())).thenReturn(ResponseDTO.builder().build());

        ResponseDTO response = reservaController.findByReserva(VueloInDTO.builder()
                        .idUsuario(1L)
                        .idVuelo(1L)
                        .idTiquete(1L)
                        .ciudad("Neiva")
                        .idReserva(1L)
                .build());
        Assertions.assertNotNull(response);

    }
}