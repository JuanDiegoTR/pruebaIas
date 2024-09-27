package com.example.pruebaias001.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VueloOutDTO {
    private Long idReserva;
    private Long idUsuario;
    private Long idVuelo;
    private Long idTiquet;
    private String ciudad;
}
