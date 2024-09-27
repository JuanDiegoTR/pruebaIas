package com.example.pruebaias001.service.Impl;

import com.example.pruebaias001.dto.ResponseDTO;
import com.example.pruebaias001.dto.VueloInDTO;
import com.example.pruebaias001.entity.ReservaEntity;
import com.example.pruebaias001.repository.ReservaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ReservaServiceImplTest {

    @Mock
    ReservaRepository reservaRepository;
    @InjectMocks
    ReservaServiceImpl reservaService;

    @Test
    void findByReserva() {
        Mockito.when(reservaRepository.findByIdUsuarioAndIdVueloAndIdTiquetAndCiudadAndId(any(),any(),any(),any(),any()))
                .thenReturn(Optional.of(ReservaEntity.builder().id(1L).build()));
        ResponseDTO  res = reservaService.findByReserva(VueloInDTO.builder()
                        .idReserva(1L)
                        .idVuelo(1L)
                        .idTiquete(1L)
                        .ciudad("Neiva")
                .idUsuario(1L)
                .build());

        Assertions.assertNotNull(res);
        Assertions.assertEquals(HttpStatus.OK.value(),res.getStatus());
    }
}