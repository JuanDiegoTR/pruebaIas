package com.example.pruebaias001.repository;

import com.example.pruebaias001.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity,Long> {

    Optional<ReservaEntity> findByIdUsuarioAndIdVueloAndIdTiquetAndCiudadAndId(Long idUsuario,
                                                                               Long idVuelo,
                                                                               Long idTiquet,
                                                                               String ciudad,
                                                                               Long idReserva);

}
