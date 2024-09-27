package com.example.pruebaias001.util;

import com.example.pruebaias001.exception.CustomException;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.Objects;

public class Validaciones {
    public static void  validacionesSoloNumeros(String parametro, String nombre){
        validacionesNuloVacio(parametro, nombre);
        if(!parametro.matches("^\\d+$")){
            throw new CustomException(HttpStatus.BAD_REQUEST.value(),
                    MessageFormat.format("El parametro {0}, solo debe tener numeros", nombre));
        }
    }
    public static void  validacionesSoloLetras(String parametro, String nombre){
        validacionesNuloVacio(parametro, nombre);
        if(!parametro.matches("^[a-zA-Z]+$")){
            throw new CustomException(HttpStatus.BAD_REQUEST.value(),
                    MessageFormat.format("El parametro {0}, solo debe tener letras", nombre));
        }
    }

    public static void validacionesNuloVacio(String parametro, String nombre){
        if(Objects.isNull(parametro)||parametro.isEmpty()){
            throw new CustomException(HttpStatus.BAD_REQUEST.value(),
                    MessageFormat.format("El parametro {0}, no puede llegar nulo o vacio", nombre));
        }
    }
}
