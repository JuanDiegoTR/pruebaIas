package com.example.pruebaias001.service;

import com.example.pruebaias001.dto.ResponseDTO;
import com.example.pruebaias001.dto.VueloInDTO;

public interface ReservaService {
    ResponseDTO findByReserva(VueloInDTO vueloInDTO);
}
