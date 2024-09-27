package com.example.pruebaias001.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "id_vuelo")
    private Long idVuelo;
    @Column(name = "id_tiquete")
    private Long idTiquet;
    @Column(name = "ciudad")
    private String ciudad;
}
