package com.example.pruebaias001.controller;

import com.example.pruebaias001.dto.ResponseDTO;
import com.example.pruebaias001.dto.VueloInDTO;
import com.example.pruebaias001.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping(value = "airline")
    public ResponseDTO findByReserva(@RequestBody VueloInDTO vueloInDTO){
        return reservaService.findByReserva(vueloInDTO);
    }

}
