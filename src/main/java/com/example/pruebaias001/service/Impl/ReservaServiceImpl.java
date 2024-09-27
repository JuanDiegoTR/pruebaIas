package com.example.pruebaias001.service.Impl;

import com.example.pruebaias001.dto.ResponseDTO;
import com.example.pruebaias001.dto.VueloInDTO;
import com.example.pruebaias001.dto.VueloOutDTO;
import com.example.pruebaias001.entity.ReservaEntity;
import com.example.pruebaias001.exception.CustomException;
import com.example.pruebaias001.repository.ReservaRepository;
import com.example.pruebaias001.service.ReservaService;
import com.example.pruebaias001.util.Validaciones;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    @Override
    public ResponseDTO findByReserva(VueloInDTO vueloInDTO) {

        Validaciones.validacionesSoloNumeros(String.valueOf(vueloInDTO.getIdReserva()), "idReserva");
        Validaciones.validacionesSoloNumeros(String.valueOf(vueloInDTO.getIdVuelo()), "idVuelo");
        Validaciones.validacionesSoloNumeros(String.valueOf(vueloInDTO.getIdUsuario()), "idUsuario");
        Validaciones.validacionesSoloNumeros(String.valueOf(vueloInDTO.getIdTiquete()), "idTiquete");
        Validaciones.validacionesSoloLetras(vueloInDTO.getCiudad(), "ciudad");

        ReservaEntity reservaEntity = reservaRepository
                .findByIdUsuarioAndIdVueloAndIdTiquetAndCiudadAndId(vueloInDTO.getIdUsuario(),
                        vueloInDTO.getIdVuelo(),
                        vueloInDTO.getIdTiquete(),
                        vueloInDTO.getCiudad(),
                        vueloInDTO.getIdReserva())
                .orElseThrow(
                        () -> new CustomException(HttpStatus.PARTIAL_CONTENT.value(), "No se encontro informacion en base de datos"));


        return ResponseDTO.builder()
                .data(mapRespons(reservaEntity))
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    private VueloOutDTO mapRespons(ReservaEntity reserva) {
        return VueloOutDTO.builder()
                .idReserva(reserva.getId())
                .idTiquet(reserva.getIdTiquet())
                .idVuelo(reserva.getIdVuelo())
                .idUsuario(reserva.getIdUsuario())
                .ciudad(reserva.getCiudad())
                .build();
    }
}
