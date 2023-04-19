package com.example.lab420200334.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
@Setter
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvuelo")
    private Integer idvuelo;

    @Column(nullable = false)
    private String origen;

    private String destino;

    private Date fecha_salida;

    private Date fecha_llegada;

    private int duracion;

    private double precio;

    private int asientos_disponibles;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name ="aerolinea_idaerolinea")
    private Aerolinea aerolinea;

}
