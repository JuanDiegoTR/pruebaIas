package com.example.pruebaias001.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VueloInDTO {
    private Long idUsuario;
    private Long idVuelo;
    private Long idTiquete;
    private String ciudad;
    private Long idReserva;
}
